package com.simformsolutions.jpaprojection.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simformsolutions.jpaprojection.entity.Product;
import com.simformsolutions.jpaprojection.entity.ProductDTO;
import com.simformsolutions.jpaprojection.entity.ProductDetailsDTO;
import com.simformsolutions.jpaprojection.entity.ProductView;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findAll();
	
	List<Product> findByCategory(String category);
	
	//Class based
	List<ProductDetailsDTO> findDTOByCategory(String category);
	
	List<ProductDTO> findDTOByBrand(String brand);
	
	//Interface based
	List<ProductView> findAllProjectedBy();

	List<ProductView> findViewByCategory(String category);
	
	//dynamic
	<T> Optional<T> findById(int id, Class<T> type);
}