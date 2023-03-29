package com.dedication.inventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dedication.inventory.dto.InventoryResponse;
import com.dedication.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

		@Autowired
		InventoryRepository inventoryRepository;
		
		@Transactional(readOnly = true)
		public List<InventoryResponse> isInStock(List<String> skuCode) {
			
			return inventoryRepository.findBySkuCodeIn(skuCode).stream()
					.map(inventory->{
							InventoryResponse inventoryResponse=new InventoryResponse();
							inventoryResponse.setSkuCode(inventory.getSkuCode());
							inventoryResponse.setInStock(inventory.getQuantity() > 0);
							return inventoryResponse;
					}).collect(Collectors.toList());		
		}
		
}
