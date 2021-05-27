package com.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ust.pms.model.Product;

@RestController
@RequestMapping("/connectwithotherMS")
public class MyRestController {
	
	URI uri = URI.create("http://localhost:9090/getDataFromCloud");
	URI proUri = URI.create("http://localhost:8085/product");
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/hi")
	public ResponseEntity<String> hi() {
		
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		return response;
		
	}
	
	//@RequestMapping("/pro")
	@GetMapping
	public List<Product> pro() {
		
		ResponseEntity<Product[]> response = restTemplate.getForEntity(proUri, Product[].class);
		return Arrays.asList(response.getBody());
		
	}
	
	@PostMapping
	public String saveProduct(@RequestBody Product product) {
			
			restTemplate.postForEntity(proUri, product, String.class);			
			return "Product saved successfully";		
	}
	
	@DeleteMapping(path = "/{pp}")
	public String deleteProduct(@PathVariable("pp") Integer productId) {
			
			restTemplate.delete(proUri+ "/" +productId);			
			return "Deleted Product Successfully";		
	}
	
	@PutMapping
	public String updateProduct(@RequestBody Product product) {
			
			restTemplate.put(proUri, product);			
			return "Updated Product Successfully";
		
	}


}
