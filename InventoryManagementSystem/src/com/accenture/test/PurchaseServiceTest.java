package com.accenture.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accenture.business.bean.PurchaseEntryBean;
import com.accenture.dao.PurchaseEntryDAO;
import com.accenture.entity.PurchaseEntryEntity;
import com.accenture.service.InventoryManagementServiceIMPL;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/root-ctx.xml"})
public class PurchaseServiceTest {
	
	@Autowired
	InventoryManagementServiceIMPL inventoryManagementServiceIMPL;
	
	/*
     * Method - notNullinventoryManagementServiceIMPLTest()
     * Assert only that inventoryManagementServiceIMPL object is Not null
     */
    
    @Test
    public void notNullinventoryManagementServiceIMPLTest() {
        // Your Code Here
        assertNotNull(inventoryManagementServiceIMPL);
    }
    
    
    /*
     * Method - savePurchaseBeanTest()
     * Using InventoryManagementServiceIMPL send a bean 
     * Assert that the bean is sent and it is Not null 
     */

 

    @Test
    public void savePurchaseBeanTest() {
        // Your Code Here
    	PurchaseEntryBean bean = new PurchaseEntryBean();
    	bean.setMaterialCategoryId("C001");
    	bean.setMaterialTypeId("T001");
    	bean.setBrandId("1003");
    	bean.setPurchaseAmount(5000.0);
    	Date date1 = new Date(24-03-2021);
    	bean.setPurchaseDate(date1);
    	bean.setQuantity(5);
    	bean.setUnitId("U001");
    	bean.setVendorId("V005");
    	Integer result = inventoryManagementServiceIMPL.savePurchaseEntry(bean);
        assertNotNull(result);
    }

}
