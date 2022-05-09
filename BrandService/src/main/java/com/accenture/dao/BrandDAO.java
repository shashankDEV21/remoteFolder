package com.accenture.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.entity.BrandEntity;

public interface BrandDAO extends JpaRepository<BrandEntity, String>{

}
