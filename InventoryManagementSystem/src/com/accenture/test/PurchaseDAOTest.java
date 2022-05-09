package com.accenture.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accenture.dao.PurchaseEntryDAO;
import com.accenture.entity.PurchaseEntryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/root-ctx.xml"})
public class PurchaseDAOTest {

	//private static final Logger logger = LoggerFactory.getLogger(PurchaseEntryDAO.class);
	
	@Autowired
	PurchaseEntryDAO purchaseEntryDAO;
	
	/*
     * Method - notNullPurchaseEntryDAOWrapperTest()
     * Assert only that PurchaseEntryDAOWrapper object is Not null
     */
    
    @Test
    public void notNullPurchaseEntryDAOWrapperTest() {
        // Your Code Here
        assertNotNull(purchaseEntryDAO);
    }
    
    
    /*
     * Method - savePurchaseEntityTest()
     * Using PurchaseEntryDAOWrapper save an entity 
     * Assert that the entity is saved and it is Not null 
     */

 

    @Test
    public void savePurchaseEntityTest() {
        // Your Code Here
    	PurchaseEntryEntity entity = new PurchaseEntryEntity();
    	entity.setMaterialCategoryId("C001");
    	entity.setMaterialTypeId("T001");
    	entity.setBrandId("1001");
    	entity.setPurchaseAmount(5000);
    	Date date1 = new Date(22-03-2021);
    	entity.setPurchaseDate(date1);
    	entity.setQuantity(5);
    	entity.setUnitId("U001");
    	entity.setVendorId("V005");
        PurchaseEntryEntity purchaseEntryEntity = purchaseEntryDAO.save(entity);
        assertNotNull(purchaseEntryEntity);
    }
	
}
