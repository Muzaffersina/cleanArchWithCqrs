package com.atmosware.cleanarchwithcqrs.ws.controllers;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atmosware.cleanarchwithcqrs.application.features.account.commandsForProduct.CreateProductCommand;
import com.atmosware.cleanarchwithcqrs.ws.models.CreateProductModel;

@RestController
@RequestMapping("/product")
public class ProductContreller {
	
	private CommandGateway commandGateway;
	private QueryGateway queryGateway;
	
	
	public ProductContreller(CommandGateway commandGateway, QueryGateway queryGateway) {		
		this.commandGateway = commandGateway;
		this.queryGateway = queryGateway;
	}
	
	
	@PostMapping
	public void createProduct(@RequestBody CreateProductModel createProductModel) {
		
		CreateProductCommand command = CreateProductCommand.builder()
				.name(createProductModel.getName())
				.category(createProductModel.getCategory())
				.unitsInStock(createProductModel.getUnitsInStock())
				.description(createProductModel.getDescription())
				.build();
		command.setProductId(UUID.randomUUID().toString());
		this.commandGateway.sendAndWait(command);
		
	}
	

}
