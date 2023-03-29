package com.dedication.productservice.service;


import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dedication.productservice.dto.ProductRequest;
import com.dedication.productservice.dto.ProductResponse;
import com.dedication.productservice.model.Product;
import com.dedication.productservice.model.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

		@Autowired
		ProductRepository productRepository;
		
		Logger logger = LoggerFactory.getLogger("ProductService");
	
		public void createProduct(ProductRequest productRequest) {
			
			Product product=new Product();
			product.setName(productRequest.getName());
			product.setDescription(productRequest.getDescription());
			product.setPrice(productRequest.getPrice());
		
			productRepository.save(product);	
			logger.info("Product"+product.getId()+ "is saved");

			
		}

		public List<ProductResponse> getAllProducts() {
			List<Product> products= productRepository.findAll();
			return products.stream().map(product->mapToProductResponse(product)).collect(Collectors.toList());
			
		}

		private ProductResponse mapToProductResponse(Product product) {
			
			
			ProductResponse productResponse=new ProductResponse();
			productResponse.setId(product.getId());
			productResponse.setName(product.getName());
			productResponse.setDescription(product.getDescription());
			productResponse.setPrice(product.getPrice());
			
			return productResponse;
		}
}
