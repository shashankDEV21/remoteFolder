package com.accenture.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.business.bean.BrandBean;
import com.accenture.service.BrandService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandServiceTest {

	
	private static final Logger log = LoggerFactory.getLogger(BrandServiceTest.class);
	
	@Autowired
	private BrandService brandService;
	
	@Test
	public void notNullBrandServiceTest() {
		
		assertNotNull(brandService);
	}
	
	@Test
	public void getBrandDetailsTest() {
		List<BrandBean> beans = brandService.getBrandDetails();
		assertNotNull(beans);
		assertEquals(3,beans.size());
	}
}
