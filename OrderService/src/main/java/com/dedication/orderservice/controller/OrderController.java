package com.dedication.orderservice.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dedication.orderservice.dto.OrderRequest;
import com.dedication.orderservice.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;


@RestController
@RequestMapping("/api/order")
public class OrderController {

	
	@Autowired
	OrderService orderService;
	
	@PostMapping
	@CircuitBreaker(name = "inventory",fallbackMethod = "fallbackMethod")
	@TimeLimiter(name="inventory")
	@Retry(name = "inventory")
	public CompletableFuture<String>  placeOrder(@RequestBody OrderRequest orderRequest ) {
		
		return CompletableFuture.supplyAsync(()->orderService.placeOrder(orderRequest));
	}
	
	public CompletableFuture<String> fallbackMethod(OrderRequest orderRequest,RuntimeException runtimeException) {
			
		 return CompletableFuture.supplyAsync(()->"Oops! Something went wrong, please order after some time!");
	}
	
	
}
