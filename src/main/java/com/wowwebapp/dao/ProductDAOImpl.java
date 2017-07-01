package com.wowwebapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wowwebapp.config.HibernateConfig;
import com.wowwebapp.entities.ProductEntity;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	HibernateConfig hibernateConfig;
	
	@Override
	public List<ProductEntity> fetchProducts() {	
		return hibernateConfig.getListByCriteria(ProductEntity.class, null);
	}

	@Override
	public int insertProduct(ProductEntity productEntity) {
		// TODO Auto-generated method stub
		return hibernateConfig.saveRecord(productEntity);
	}

}
