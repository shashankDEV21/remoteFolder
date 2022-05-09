package com.accenture.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.accenture.business.bean.BrandBean;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BrandClient {

	private static final String BrandServiceURI="http://localhost:8090/";
	
	public List<BrandBean> getBrandDetails()
	{
		List<BrandBean> brandBeans=new ArrayList<BrandBean>();
		RestTemplate restTemplate=new RestTemplate();
		List<LinkedHashMap<String, Object>> jsonMap=restTemplate.getForObject(BrandServiceURI+"brand/controller/getBrands", List.class);
		ObjectMapper mapper=new ObjectMapper();
		
		if(jsonMap!=null)
			for (LinkedHashMap<String, Object> linkedHashMap : jsonMap) {
				brandBeans.add(mapper.convertValue(linkedHashMap, BrandBean.class));
			}
		
		return brandBeans;
	}
}
