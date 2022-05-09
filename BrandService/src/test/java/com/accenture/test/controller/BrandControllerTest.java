package com.accenture.test.controller;

 


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.accenture.business.bean.BrandBean;
import com.accenture.controller.BrandController;
import com.accenture.service.BrandService;

 

@RunWith(SpringRunner.class)
@WebMvcTest(BrandController.class)
public class BrandControllerTest {

 

    
    private static final Logger log = LoggerFactory.getLogger(BrandControllerTest.class);

 

    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private BrandService brandServiceMock;
//    
//    @Test
//    public void welcomeMessageTest() throws Exception {
//        log.info("----Starting test welcomeMessageTest()----");
//        
//        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk())
//                                                        .andExpect(content().string("Welcome to Brand Service"));
//    }
    
    @Test
	public void indexBrandControllerTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk())
				.andExpect(content().string("Welcome to Spring Boot Brand Service API - Heellooo!"));
	}
    @Test
    public void getBrandDetailsTest() throws Exception {
        
        List<BrandBean> beans = new ArrayList<>();
        BrandBean bean = new  BrandBean();
        bean.setBrandId("1001");
        bean.setBrandName("Lewis");
        beans.add(bean);
        bean.setBrandId("1002");
        bean.setBrandName("Raymond");
        beans.add(bean);
        bean.setBrandId("1003");
        bean.setBrandName("denim");
        beans.add(bean);
        
//        bean = new BrandBean("1002","Raymond");
//        beans.add(bean);
//        bean = new BrandBean("1003","denim");
//        beans.add(bean);
        
        when(brandServiceMock.getBrandDetails()).thenReturn(beans);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/brand/controller/getAllBrands"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        
        .andExpect(jsonPath("$[0].brandId").exists())
        .andExpect(jsonPath("$[0].brandName").exists())
        
        .andExpect(jsonPath("$[0].brandId").isString())
        .andExpect(jsonPath("$[0].brandName").isString())
        
        .andExpect(jsonPath("$[0].brandId").value("1001"))
        .andExpect(jsonPath("$[0].brandName").value("Lewis"));
        
    }
    
}