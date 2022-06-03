package com.simformsolutions.jpaprojection;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.simformsolutions.jpaprojection.entity.ProductDTO;
import com.simformsolutions.jpaprojection.entity.ProductView;
import com.simformsolutions.jpaprojection.repository.ProductRepository;

@SpringBootApplication
public class SpringBootJpaProjectionExampleApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootJpaProjectionExampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaProjectionExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository productRepository) {
		return (args) -> {
			// save a few books
//			productRepository.save(new Product("mobile", "SAMSUNG", "electronics", 60000));
//			productRepository.save(new Product("bottle", "Servewell", "Vessels", 800));
//			productRepository.save(new Product("mobile", "oneplus", "electronics", 45000));

			// fetch all books
			log.info("Products found with findAll():");
			log.info("-------------------------------");
			productRepository.findAll().forEach(product -> log.info(product.toString()));
			log.info("");

			// fetch all books
			log.info("Products found with findAllProjectedBy():");
			log.info("-------------------------------");
			productRepository.findAllProjectedBy().forEach(productView -> log.info("Book View {}, {}, {} ",
					productView.getType(), productView.getBrand(), productView.getPrice()));
			log.info("");

			// fetch Products by author name Entity Based
			log.info("Entity Based: Book found with findByCategory('electronics'):");
			log.info("--------------------------------------------");
			productRepository.findByCategory("electronics").forEach(product -> {
				log.info(product.toString());
			});

			// fetch Products by author name Class Based
			log.info("Class Based: Product found with findDTOByCategory('electronics'):");
			log.info("------------------------------------------");
			productRepository.findDTOByCategory("electronics").forEach(product -> {
				log.info(product.toString());
			});

			// fetch Products by brand name Class Based
			log.info("Class Based: Product found with findDTOByBrand(String brand):");
			log.info("------------------------------------------");
			productRepository.findDTOByBrand("SAMSUNG").forEach(product -> {
				log.info(product.toString());
			});

			// fetch Products by brand name dynamic Class Based
			log.info("Class Based: Product found with findDTOByBrand(String brand):");
			log.info("------------------------------------------");
			log.info("{}",productRepository.findById(1,ProductDTO.class));
			

			// fetch Products by author name Interface Based
			log.info("Interface Based: Product found with findByCategory('electronics'):");
			log.info("--------------------------------------------");
			List<ProductView> products = productRepository.findViewByCategory("electronics");
			products.forEach(product -> {
				log.info("ProductView {}, {}, {}", product.getType(), product.getBrand(), product.getPrice());
			});
			log.info("");
		};
	}

}
