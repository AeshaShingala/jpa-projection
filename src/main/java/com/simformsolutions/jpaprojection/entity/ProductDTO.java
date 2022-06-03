package com.simformsolutions.jpaprojection.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ProductDTO {
	private String type;
	private String category;
	private int price;
}
