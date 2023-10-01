package com.demo.second.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.second.entity.ProductInfo;

@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, Integer> {

}
