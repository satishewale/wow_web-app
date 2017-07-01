package com.wowwebapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wowwebapp.entities.ProductEntity;
import com.wowwebapp.services.ProductService;

@RestController
@RequestMapping("wowwebapp/product/")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "getProducts", method = RequestMethod.GET)
	public List<ProductEntity> getProductList(){
		
		return productService.getProductList();
	};
	
	@RequestMapping(value = "addProduct", method = RequestMethod.POST)
	public int addProduct(@RequestBody ProductEntity productEntity){
		System.out.println(productEntity.getBrand());
		
		return productService.addProduct(productEntity);
	}
	

}
