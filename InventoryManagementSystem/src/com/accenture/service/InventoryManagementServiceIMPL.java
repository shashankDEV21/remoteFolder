package com.accenture.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.business.bean.BrandBean;
import com.accenture.business.bean.MaterialCategoryBean;
import com.accenture.business.bean.MaterialTypeBean;
import com.accenture.business.bean.PurchaseEntryBean;
import com.accenture.business.bean.UnitBean;
import com.accenture.business.bean.VendorBean;
import com.accenture.dao.BrandClient;
import com.accenture.dao.MaterialClient;
import com.accenture.dao.PurchaseEntryDAO;
import com.accenture.dao.PurchaseEntryDAOWrapper;
import com.accenture.dao.VendorClient;

@Service
public class InventoryManagementServiceIMPL {
	@Autowired
	BrandClient brandCLient;
	
	@Autowired
	MaterialClient materialClient;
	
	@Autowired
	VendorClient vendorClient;
	
	@Autowired
	PurchaseEntryDAOWrapper daoWrapper;
	
	public Map<String, String> getBrandMap()
	{
		HashMap<String, String>  map=new HashMap<String, String>();
		List<BrandBean> beans=brandCLient.getBrandDetails();
		for (BrandBean brandBean : beans) {
			map.put(brandBean.getBrandId(), brandBean.getBrandName());
		}
		return map;
	}
	
	
	public int savePurchaseEntry(PurchaseEntryBean bean)
	{
		return daoWrapper.savePurchaseEntry(bean);
	}
	
	public Map<String, String> getMaterialCategoryMap()
	{
		Map<String, String> map=new HashMap<String, String>();
	 	List<MaterialCategoryBean> categoryBeans=materialClient.getMaterialCategoryList();
	 	
	 	for (MaterialCategoryBean materialCategoryBean : categoryBeans) {
			map.put(materialCategoryBean.getCategoryId(), materialCategoryBean.getCategoryName());
		}
	 	//System.out.println(map.size());
	 	return map;
	}

	
	public Map<String,String> getMaterialTypeMap()
	{
		Map<String, String> map=new HashMap<String, String>();
		List<MaterialTypeBean> beans=materialClient.getMaterialTypeList();
		
		for (MaterialTypeBean materialTypeBean : beans) {
			map.put(materialTypeBean.getTypeId(), materialTypeBean.getTypeName());
		}
		return map;
	}

	public Map<String,String> getUnitMap()
	{
		Map<String, String> map=new HashMap<String, String>();
		materialClient.getUnitList().forEach((UnitBean bean)->	map.put(bean.getUnitId(),bean.getUnitName()));
		return map;
		
	}
	
	public Map<String, String> getVendorNamesMap()
	{
		Map<String, String> map=new HashMap<String, String>();
		vendorClient.getVendorList().forEach((VendorBean bean)->map.put(bean.getVendorId(),bean.getVendorName()));
		return map;
	}
}
