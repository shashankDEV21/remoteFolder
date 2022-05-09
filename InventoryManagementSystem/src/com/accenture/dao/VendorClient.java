package com.accenture.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.accenture.business.bean.VendorBean;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class VendorClient {

	public final static String vendorServiceURI="http://localhost:8070/"; 
	
	public List<VendorBean> getVendorList()
	{
		List<VendorBean> vendorBeans=new ArrayList<VendorBean>();
		ObjectMapper mapper=new ObjectMapper();
		RestTemplate restTemplate=new RestTemplate();
		List<LinkedHashMap<String, Object>> jsonMap=restTemplate.getForObject(vendorServiceURI+"vendor/controller/getVendors", List.class);

		if(jsonMap!=null)
			for (LinkedHashMap<String, Object> linkedHashMap : jsonMap) {
				vendorBeans.add(mapper.convertValue(linkedHashMap, VendorBean.class));
			}
		return vendorBeans;
	}
	
}
