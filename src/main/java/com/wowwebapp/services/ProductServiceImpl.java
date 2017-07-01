package com.wowwebapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wowwebapp.dao.ProductDAO;
import com.wowwebapp.entities.ProductEntity;

@Service("ProductService")
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDAO productDao;

	@Override
	public List<ProductEntity> getProductList() {
		
		List<ProductEntity> productEntity = productDao.fetchProducts();
		return productEntity;
	}

	@Override
	public int addProduct(ProductEntity productEntity) {
		
		return productDao.insertProduct(productEntity);
	}

}
