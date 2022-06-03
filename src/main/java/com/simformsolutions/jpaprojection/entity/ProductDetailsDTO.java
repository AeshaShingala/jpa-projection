package com.simformsolutions.jpaprojection.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ProductDetailsDTO {
	private String type;
	private String brand;
	private int price;
}
