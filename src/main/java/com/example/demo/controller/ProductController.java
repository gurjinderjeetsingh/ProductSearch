package com.example.demo.controller;


import java.util.List;

import javax.websocket.server.PathParam;

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

import com.example.demo.service.ProductService;


import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getProducts() {
		return new ResponseEntity<List<Product>>(productService.getProducts(), HttpStatus.OK) ;
	}
	
	
	@GetMapping("/get/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {
		return new ResponseEntity<Product>(productService.getProductById(productId),HttpStatus.OK);
	}
	
	@GetMapping("/getCount/{productId}")
	public ResponseEntity<Long> getProductCountById(@PathVariable("productId") Long productId)  {
		return new ResponseEntity<Long>(productService.getProductCountById(productId),HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		System.out.println("Product is "+product); 
		return new ResponseEntity<String>(productService.saveProduct(product),HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateeProduct(@RequestBody Product product) {
		return new ResponseEntity<String>(productService.saveProduct(product),HttpStatus.OK);
	}
	
	@DeleteMapping("/get/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {
		return new ResponseEntity<String>(productService.deleteProduct(productId),HttpStatus.OK);
	}
	
	@GetMapping("/getByBrand/{brand}")
	public ResponseEntity<List<Product>> getProductByBrand(@PathVariable("brand") String brand){
		return new ResponseEntity<List<Product>>(productService.getProductByBrand(brand),HttpStatus.OK);
	}
	
	@GetMapping("/getBySku/{sku}")
	public ResponseEntity<List<Product>> getProductBySku(@PathVariable("sku") String sku) throws ProductNotFoundException {
		return new ResponseEntity<List<Product>>(productService.getProductBySku(sku),HttpStatus.OK);
	}
	
	@GetMapping("/getBySellerAndProductId/{seller}/{productId}")
	public ResponseEntity<List<Product>> getProductBySellerAndProductId(@PathVariable("seller") String seller,@PathVariable("productId") Long productId) throws ProductNotFoundException {
		return new ResponseEntity<List<Product>>(productService.getProductBySellerAndProductId(seller, productId),HttpStatus.OK);
	}
	
}
