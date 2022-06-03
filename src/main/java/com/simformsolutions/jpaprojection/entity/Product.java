package com.simformsolutions.jpaprojection.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private String brand;
	private String category;
	private int price;
	public Product(String type, String brand, String category, int price) {
		super();
		this.type = type;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}
	
}
