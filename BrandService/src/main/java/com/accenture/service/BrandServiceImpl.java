package com.accenture.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.business.bean.BrandBean;
import com.accenture.dao.BrandDAO;
import com.accenture.entity.BrandEntity;

@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	BrandDAO brandDao;
	
	@Override
	public List<BrandBean> getBrandDetails() {
		List<BrandBean> beans=new ArrayList<BrandBean>();
		List<BrandEntity> brandEntities=brandDao.findAll();
		
		if(brandEntities != null)
		{
			for (BrandEntity brandEntity : brandEntities) {
				BrandBean bean=new BrandBean();
				System.out.println(brandEntity.getBrandName());
				BeanUtils.copyProperties(brandEntity, bean);
				beans.add(bean);
			}
		}
		
		return beans;
	}

	
}
