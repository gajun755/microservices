package com.dedication.orderservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.dedication.orderservice.dto.InventoryResponse;
import com.dedication.orderservice.dto.OrderLineItemsDto;
import com.dedication.orderservice.dto.OrderRequest;
import com.dedication.orderservice.model.Order;
import com.dedication.orderservice.model.OrderLineItems;
import com.dedication.orderservice.repository.OrderRepository;

@Service
@Transactional
public class OrderService {

	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	private final Tracer tracer = null;
	
	public String placeOrder(OrderRequest orderRequest){
		
		Order order=new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		List<OrderLineItems> orderLineItems= orderRequest.getOrderLineItemsDtoList().stream().map(orderLineItemsDto->mapToDto(orderLineItemsDto)).collect(Collectors.toList());
		order.setOrderLineItemList(orderLineItems);
		
		List<String> skuCodes = order.getOrderLineItemList().stream()
					.map(orderLineItem->orderLineItem.getSkuCode())
					.toList();
		
		Span inventoryServiceLookup =tracer.nextSpan().name("InventoryServiceLookup");
		try(Tracer.SpanInScope spaceInScope= tracer.withSpan(inventoryServiceLookup.start())){
			//Call Inventory Service, and place order if product is in
			// Stock 
			InventoryResponse[] inventoryResponseArray= webClientBuilder.build().get()
					.uri("http://inventory-service/api/inventory",
							uriBuilder->uriBuilder.queryParam("skuCode", skuCodes).build())
					.retrieve()
					.bodyToMono(InventoryResponse[].class)
					.block();
			
			 boolean allProductsInStock= Arrays.stream(inventoryResponseArray).allMatch(inventoryResponse->inventoryResponse.isInStock());
			
			if(allProductsInStock) {
			orderRepository.save(order);
			return "Order Saved Successfully";
			}else {
				throw new IllegalArgumentException("Product is not in stock , please try again later");
			}
		}finally {
			inventoryServiceLookup.end();
		}
		
	}

	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
		
		OrderLineItems orderLineItems=new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
		return orderLineItems;
	}
}
