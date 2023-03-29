package com.dedication.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dedication.productservice.dto.ProductRequest;
import com.dedication.productservice.dto.ProductResponse;
import com.dedication.productservice.model.Product;
import com.dedication.productservice.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	
	@Autowired
	ProductService productService;
	
	@PostMapping()
	public ResponseEntity<Product> creatProduct(@RequestBody ProductRequest productRequest) {
		
		productService.createProduct(productRequest);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public List<ProductResponse> getAllProducts(){
		
		return productService.getAllProducts();
		
	}
}
