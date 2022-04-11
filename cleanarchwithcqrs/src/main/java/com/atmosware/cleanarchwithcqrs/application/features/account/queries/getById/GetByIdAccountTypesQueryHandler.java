package com.atmosware.cleanarchwithcqrs.application.features.account.queries.getById;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atmosware.cleanarchwithcqrs.domain.AccountType;
import com.atmosware.cleanarchwithcqrs.persistence.AccountTypeRepository;

@Component
public class GetByIdAccountTypesQueryHandler {
	
	private AccountTypeRepository accountTypeRepository;

	@Autowired
	public GetByIdAccountTypesQueryHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}
		
	@QueryHandler
	public GetByIdAccountTypesDto getByIdAccountTypes(GetByIdAccountTypesQuery getByIdAccountTypesQuery) {
		
		AccountType accountType = this.accountTypeRepository.getById(getByIdAccountTypesQuery.getAccountTypeId());
		
		GetByIdAccountTypesDto getByIdAccountTypesDto = new GetByIdAccountTypesDto();
		BeanUtils.copyProperties(accountType, getByIdAccountTypesDto);
		
		
		return getByIdAccountTypesDto;
		
	}

}
