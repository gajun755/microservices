package com.dedication.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dedication.inventory.dto.InventoryResponse;
import com.dedication.inventory.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

		
		@Autowired
		InventoryService inventoryService;
		
		@GetMapping
		@ResponseStatus(value = HttpStatus.OK)
		public  List<InventoryResponse>  isInStock(@RequestParam List<String> skuCode) {
				
			return inventoryService.isInStock(skuCode) ;
		}
		
	
}
