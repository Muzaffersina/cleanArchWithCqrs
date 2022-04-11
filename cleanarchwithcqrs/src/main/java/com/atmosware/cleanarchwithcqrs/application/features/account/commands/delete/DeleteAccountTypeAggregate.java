package com.atmosware.cleanarchwithcqrs.application.features.account.commands.delete;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class DeleteAccountTypeAggregate {
	
	@AggregateIdentifier
	private String accountTypeId;
	
	public DeleteAccountTypeAggregate() {		
		
	}

	@CommandHandler
	public DeleteAccountTypeAggregate(DeleteAccountTypeCommand command) {	
		
		AccountTypeDeletedEvent deletedEvent = new AccountTypeDeletedEvent();
		
		BeanUtils.copyProperties(command, deletedEvent);
		System.out.println(deletedEvent.getAccountTypeId());
		AggregateLifecycle.apply(deletedEvent);
	}
	
	
	@EventSourcingHandler
	public void on(AccountTypeDeletedEvent accountTypeDeletedEvent) {
		AggregateLifecycle.markDeleted();
		//this.accountTypeId = accountTypeDeletedEvent.getAccountTypeId();		
	}

}
