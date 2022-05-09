package com.accenture.dao;


import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.entity.PurchaseEntryEntity;

@RepositoryDefinition(idClass = Integer.class,domainClass = PurchaseEntryEntity.class)
@Transactional("txManager")
public interface PurchaseEntryDAO {
	
	PurchaseEntryEntity save(PurchaseEntryEntity entity);
	//PurchaseEntryEntity findOne(PurchaseEntryEntity entity);
	
}
