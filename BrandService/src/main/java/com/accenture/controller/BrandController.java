package com.accenture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.business.bean.BrandBean;
import com.accenture.service.BrandServiceImpl;

@RestController
public class BrandController {

	@Autowired
	BrandServiceImpl service;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String index()
	{
		return "Welcome to the brand Service";
	}
	
	@RequestMapping(value = "brand/controller/getBrands",method = RequestMethod.GET)
	public ResponseEntity<List<BrandBean>> getBrandDetails()
	{
		List<BrandBean> beans=service.getBrandDetails();
		return new ResponseEntity<List<BrandBean>>(beans,HttpStatus.OK);
	}
}
