package com.atmosware.cleanarchwithcqrs.application.features.account.commandsForProduct;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class CreateProductAggregate {

	@AggregateIdentifier
	private String productId;

	private String name;

	private String description;

	private int unitsInStock;

	private String category;

	public CreateProductAggregate() {

	}

	@CommandHandler
	public CreateProductAggregate(CreateProductCommand command) {
		
		ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
		
		BeanUtils.copyProperties(command, productCreatedEvent);
		AggregateLifecycle.apply(productCreatedEvent);
	}
	
	@EventSourcingHandler
	public void on(ProductCreatedEvent productCreatedEvent) {
		
		this.productId = productCreatedEvent.getProductId();
		this.name = productCreatedEvent.getName();
		this.description = productCreatedEvent.getDescription();
		this.unitsInStock = productCreatedEvent.getUnitsInStock();
		this.category = productCreatedEvent.getCategory();
	}

}
