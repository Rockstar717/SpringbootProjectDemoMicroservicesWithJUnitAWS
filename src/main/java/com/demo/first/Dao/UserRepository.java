package com.demo.first.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.first.entity.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {

	//void findAll(UserInfo userInfo);
 
}
