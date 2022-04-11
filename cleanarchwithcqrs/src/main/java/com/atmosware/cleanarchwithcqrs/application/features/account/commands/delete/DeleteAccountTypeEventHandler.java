package com.atmosware.cleanarchwithcqrs.application.features.account.commands.delete;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atmosware.cleanarchwithcqrs.domain.AccountType;
import com.atmosware.cleanarchwithcqrs.persistence.AccountTypeRepository;

@Component
public class DeleteAccountTypeEventHandler {

	private AccountTypeRepository accountTypeRepository;

	@Autowired
	public DeleteAccountTypeEventHandler(AccountTypeRepository accountTypeRepository) {		
		this.accountTypeRepository = accountTypeRepository;
	}
	
	@EventHandler
	public void on(AccountTypeDeletedEvent accountTypeDeletedEvent) {
		
		AccountType accountType = new AccountType();
		BeanUtils.copyProperties(accountTypeDeletedEvent, accountType);
		this.accountTypeRepository.deleteById(accountType.getAccountTypeId());		
	}
}
