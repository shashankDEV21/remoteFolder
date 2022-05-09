package com.accenture.dao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.accenture.business.bean.MaterialCategoryBean;
import com.accenture.business.bean.MaterialTypeBean;
import com.accenture.business.bean.UnitBean;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class MaterialClient {

	public final String materailServiceURI="http://localhost:8088/"; 

	
	@SuppressWarnings("unchecked")
	public List<MaterialCategoryBean> getMaterialCategoryList()
	{
		RestTemplate restTemplate= new RestTemplate();
		List<LinkedHashMap<String, Object>> jsonMap=restTemplate.getForObject(materailServiceURI+"material/controller/getMaterialCategories", List.class);
		
		ObjectMapper mapper=new ObjectMapper();
		List<MaterialCategoryBean>  categoryBeans=new ArrayList<MaterialCategoryBean>();
		
		if(jsonMap!=null)
		{
			System.out.println(jsonMap.size());
			for (LinkedHashMap<String, Object> map: jsonMap) {
				
				categoryBeans.add(mapper.convertValue(map, MaterialCategoryBean.class));
			}
			
			for (MaterialCategoryBean materialCategoryBean : categoryBeans) {
				System.out.println(materialCategoryBean.getCategoryName());
			}
			return categoryBeans;
			
		}else
		{
			System.out.println("Map is empty");
			return null;
		}
	}
	
	public List<MaterialTypeBean> getMaterialTypeList()
	{
		RestTemplate restTemplate=new RestTemplate();
		
		List<LinkedHashMap<String, Object>> jsonMap=restTemplate.getForObject(materailServiceURI+"type/controller/getTypeDetails", List.class);
		
		ObjectMapper mapper=new ObjectMapper();
		List<MaterialTypeBean> typeBeans=new ArrayList<MaterialTypeBean>();
		if(jsonMap!=null)
		{
			for (LinkedHashMap<String, Object> map:jsonMap) {
				
				typeBeans.add(mapper.convertValue(map, MaterialTypeBean.class));
			}
		}
		
		return typeBeans;
	}

	public List<UnitBean> getUnitList()
	{
		List<UnitBean> unitBeans=new ArrayList<UnitBean>();
		RestTemplate restTemplate=new RestTemplate();
		List<LinkedHashMap<String,Object>> jsonMap=restTemplate.getForObject(materailServiceURI+"unit/controller/getUnitDetails", List.class);
		ObjectMapper mapper=new ObjectMapper();
		
		if(jsonMap!=null)
			for (LinkedHashMap<String, Object> linkedHashMap : jsonMap) {
				unitBeans.add(mapper.convertValue(linkedHashMap, UnitBean.class));
			}
		return unitBeans;
	}
	
	
}
