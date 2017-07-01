package com.wowwebapp.services;

import java.util.List;

import com.wowwebapp.entities.ProductEntity;

public interface ProductService {
	
	public List<ProductEntity> getProductList();
	public int addProduct(ProductEntity productEntity);
}
