package com.atmosware.cleanarchwithcqrs.ws.models;

import lombok.Data;

@Data
public class CreateProductModel {
	
	private String name;

	private String description;

	private int unitsInStock;

	private String category;
}
