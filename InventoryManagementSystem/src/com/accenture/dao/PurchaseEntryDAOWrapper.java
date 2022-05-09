package com.accenture.dao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.business.bean.PurchaseEntryBean;
import com.accenture.entity.PurchaseEntryEntity;

@Repository
public class PurchaseEntryDAOWrapper {

	@Autowired
	PurchaseEntryDAO purchaseEntryDAO;
	
	public int savePurchaseEntry(PurchaseEntryBean entryBean)
	{
		PurchaseEntryEntity entryEntity=convertPurchaseEntryBeanToEntity(entryBean);
		entryEntity=purchaseEntryDAO.save(entryEntity);
		return entryEntity.getPurchaseEntryId();
	}
	
//	public String savePurchaseEntryWithTransactionId(PurchaseEntryBean entryBean)
//	{
//		PurchaseEntryEntity entryEntity=convertPurchaseEntryBeanToEntity(entryBean);
//		String transactionId="";
//		int id=savePurchaseEntry(entryEntity);
//		
//		
//		transactionId="P_"+;
//		
//		
//		return transactionId;
//		
//	}
	static PurchaseEntryBean convertPurchaseEntryEntityToBean(PurchaseEntryEntity purchaseEntryEntity)
	{
		PurchaseEntryBean  bean=new PurchaseEntryBean();
		BeanUtils.copyProperties(bean, purchaseEntryEntity);
		return bean;
	}
	
	static PurchaseEntryEntity convertPurchaseEntryBeanToEntity(PurchaseEntryBean purchaseEntryBean)
	{
		PurchaseEntryEntity entity=new PurchaseEntryEntity();
		BeanUtils.copyProperties(purchaseEntryBean, entity);
		return entity;
	}
}
