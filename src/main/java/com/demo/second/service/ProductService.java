package com.demo.second.service;

import java.util.List;

import com.demo.second.entity.ProductInfo;

public interface ProductService {

  public  String createProduct(ProductInfo productInfo);
	
	public String updateProduct(ProductInfo productInfo);
	
	public String deleteProduct(ProductInfo productInfo);
	
	public List<ProductInfo> getUser();
	
	//public UserInfo findProductById(int productId);
}
