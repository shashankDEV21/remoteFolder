//package com.accenture.test.dao;
//
// 
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
// 
//
//
//import java.util.List;
//
// 
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
// 
//
//import com.accenture.dao.BrandDAO;
//import com.accenture.entity.BrandEntity;
//
// 
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class BrandDaoTest {
//
// 
//
//    
//    private static final Logger log = LoggerFactory.getLogger(BrandDaoTest.class);
//
// 
//
//    
//    @Autowired
//    private BrandDAO brandDao;
//    
//    @Test
//    public void notNullBrandDaoTest() {
//        
//        assertNotNull(brandDao);
//    }
//    
//    @Test
//    public void findByBrandIdTest() {
//    
//        String brandId= "1001";
//        List<BrandEntity> entities = brandDao.findById(brandId);
//        assertNotNull(entities);
//        assertEquals("Lewis", entities.get(0).getBrandName());
//    }
//    
//    @Test
//    public void getAllBrandsTest() {
//        List<BrandEntity> entities = brandDao.findAll();
//        assertNotNull(entities);
//        assertEquals(3, entities.findAll().size());
//    }
//}