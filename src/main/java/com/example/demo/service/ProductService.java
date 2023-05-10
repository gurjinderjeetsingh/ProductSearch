package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProducts() {
		List<Product> products=productRepository.findAll();
		System.out.println("Products are "+products); 
		return products;
	}

	public String saveProduct(Product product) {
		productRepository.save(product);
		return "Product Saved Successfully";
	}

	public String updateProduct(Product product) {
		productRepository.save(product);
		return "Product Updated Successfully";
	}

	public String deleteProduct(Long productId) throws ProductNotFoundException {
		Optional<Product> product = productRepository.findById(productId);
		if (!product.isPresent())
			throw new ProductNotFoundException("Not Found");

		productRepository.delete(product.get());
		return "Product Deleted Successfully";
	}

	public Product getProductById(Long productId) throws ProductNotFoundException {
		Optional<Product> product = productRepository.findById(productId);
		if (!product.isPresent())
			throw new ProductNotFoundException("Product Not Found with id "+productId);

		return product.get();
	}

	public List<Product> getProductByBrand(String brand) {
		return productRepository.findByBrand(brand);
	}

	public List<Product> getProductBySku(String sku) {
		return productRepository.findBySku(sku);
	}
	
	public Long getProductCountById(Long productId) {
		return productRepository.countByProductId(productId);
	}

	public List<Product> getProductBySellerAndProductId(String seller, Long productId)
			 {
		return productRepository.findBySellerAndProductId(seller, productId);
	}
}
