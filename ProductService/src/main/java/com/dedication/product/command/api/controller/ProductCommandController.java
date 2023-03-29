package com.dedication.product.command.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

		public String addProduct() {
			
			return "Product Added";
		}
	
}
