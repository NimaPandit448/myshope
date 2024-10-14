package com.myshope.myshope.service;

import java.util.List;

import com.myshope.myshope.entity.UserEntity;

public interface UserService {
	
	public int add(UserEntity usermodel);
	public List<UserEntity> findAll();
	public UserEntity findOne(Long id);
	public void delete(Long id);
	
}
