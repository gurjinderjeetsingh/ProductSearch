package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
 
	List<Product> findByProductName(String productname);
	List<Product> findByProductCategory(String productcategory);
	List<Product> findByBrand(String brand);
	List<Product> findByPrice(Double Price);
	List<Product> findByColor(String Color);
	List<Product> findBySize(Integer Size);
	List<Product> findBySku(String sku);
	List<Product> findBySeller(String seller);
	List<Product> findBySellerAndProductId(String seller,Long productId);
	Long countByProductId(Long productId);
	
	
	
	
}
