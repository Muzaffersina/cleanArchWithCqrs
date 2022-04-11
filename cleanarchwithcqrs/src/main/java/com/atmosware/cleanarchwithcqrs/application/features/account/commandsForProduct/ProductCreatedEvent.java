package com.atmosware.cleanarchwithcqrs.application.features.account.commandsForProduct;

import lombok.Data;

@Data
public class ProductCreatedEvent {
	
	private String productId;

	private String name;

	private String description;

	private int unitsInStock;

	private String category;

}
