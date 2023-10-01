package com.demo.second.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.second.Dao.ProductRepository;
import com.demo.second.entity.ProductInfo;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
	}

	@Override
	public String createProduct(ProductInfo productInfo) {
		productRepository.save(productInfo);
		return "Insert data in h2";
	}

	@Override
	public String updateProduct(ProductInfo productInfo) {
		productRepository.save(productInfo);
		return "update data H2";
	}

	@Override
	public String deleteProduct(ProductInfo productInfo) {
		productRepository.delete(productInfo);
		return "delete data in H2";
	}

	@Override
	public List<ProductInfo> getUser() {
		
		return productRepository.findAll();
	}

//	@Override
//	public ProductInfo findProductById(int productId) {
//		if(productRepository.findById(productId).isEmpty());
//		throw new UserNotFoundException("user does not exist");
//		return productRepository.findById(productId).get();
//	}

}
