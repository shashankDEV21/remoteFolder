package com.accenture.web.controller;

import java.text.SimpleDateFormat;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.business.bean.PurchaseEntryBean;
import com.accenture.service.InventoryManagementServiceIMPL;


@Controller
@SessionAttributes("user")
public class PurchaseEntryController {
	
	@Autowired
	InventoryManagementServiceIMPL service;
	
	@RequestMapping("loadPurchaseEntry.htm")
	public ModelAndView loadPurchaseEntryPage()
	{
		return new ModelAndView("PurchaseEntry","purchaseEntryBean",new PurchaseEntryBean()); 
	}
	
	@RequestMapping(value = "processPurchase.htm",method = RequestMethod.POST)
	public ModelAndView processPurchase(@ModelAttribute("purchaseEntryBean")@Valid PurchaseEntryBean entryBean,BindingResult result)
	{
		ModelAndView mv=new ModelAndView();
		if(result.hasErrors())
		{
			mv.setViewName("PurchaseEntry");
			return mv;
		}
		int id=service.savePurchaseEntry(entryBean);
		mv.setViewName("Success");
		
		String vendorName = populateVendorName().get(entryBean.getVendorId());
		String vendorNamesubString=vendorName.substring(0, 3);
		String matCat = populateMaterialCategoryList().get(entryBean.getMaterialCategoryId());
		String matType=populateMaterialTypeList().get(entryBean.getMaterialTypeId());
		String unitName=populateUnitList().get(entryBean.getUnitId());
		String brandName=getBrandNamesMap().get(entryBean.getBrandId());
		String matCatSubString=matCat.substring(0, 3).toUpperCase();
		SimpleDateFormat df=new SimpleDateFormat("ddMMyyyy");
        String date=df.format(entryBean.getPurchaseDate());
		String purchase_id = "P_"+vendorNamesubString+"_"+date+"_"+matCatSubString+"_"+id; 
		entryBean.setTransactionId(purchase_id);
		service.savePurchaseEntry(entryBean);
		mv.addObject("entry_id", purchase_id);
		mv.addObject("purchase_id", id);
		mv.addObject("entryBean",entryBean);
		mv.addObject("vendorName",vendorName);
		mv.addObject("materialCategory",matCat);
		mv.addObject("materialType",matType);
		mv.addObject("unitName",unitName);
		mv.addObject("brandName",brandName);
		
		return mv;
	}
	
	@ModelAttribute("MaterialCategories")
	public Map<String, String> populateMaterialCategoryList()
	{
		Map<String,String> map;
		map=service.getMaterialCategoryMap();
		System.out.println("map created");
		return map;
	}
	
	@ModelAttribute("MaterialTypes")
	public Map<String,String> populateMaterialTypeList()
	{
		Map<String, String> map=service.getMaterialTypeMap();
		return map;
	}

	@ModelAttribute("unitTypes")
	public Map<String, String> populateUnitList()
	{
		return service.getUnitMap();
	}
	
	@ModelAttribute("vendorNames")
	public Map<String, String> populateVendorName()
	{
		return service.getVendorNamesMap();
	}
	
	@ModelAttribute("brandNames")
	public Map<String, String> getBrandNamesMap()
	{
		return service.getBrandMap();
	}
}




