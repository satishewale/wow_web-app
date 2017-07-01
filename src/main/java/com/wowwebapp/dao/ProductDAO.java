package com.wowwebapp.dao;

import java.util.List;

import com.wowwebapp.entities.ProductEntity;

public interface ProductDAO {
	
	public List<ProductEntity> fetchProducts();
	public int insertProduct(ProductEntity productEntity);

}
