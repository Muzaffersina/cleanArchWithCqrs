package com.atmosware.cleanarchwithcqrs.application.features.account.commandsForProduct;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductCommand {

	@TargetAggregateIdentifier
	private String productId;
	
	private String name;
	
	private String description;

	private int unitsInStock;

	private String category;
}
