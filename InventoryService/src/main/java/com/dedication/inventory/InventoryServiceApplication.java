package com.dedication.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.dedication.inventory.model.Inventory;
import com.dedication.inventory.repository.InventoryRepository;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	/*
	 * @Bean public CommandLineRunner loadData(InventoryRepository
	 * inventoryRepository) {
	 * 
	 * return args->{ Inventory inventory=new Inventory();
	 * inventory.setSkuCode("iphone_13"); inventory.setQuantity(100);
	 * 
	 * Inventory inventory1=new Inventory(); inventory1.setSkuCode("iphone_13_red");
	 * inventory1.setQuantity(0);
	 * 
	 * inventoryRepository.save(inventory); inventoryRepository.save(inventory1); };
	 * }
	 */
	
}