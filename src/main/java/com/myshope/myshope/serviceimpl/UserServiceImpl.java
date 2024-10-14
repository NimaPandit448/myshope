package com.myshope.myshope.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myshope.myshope.entity.UserEntity;
import com.myshope.myshope.model.Usermodel;
import com.myshope.myshope.repository.UserRepository;
import com.myshope.myshope.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	@javax.annotation.Resource
	UserRepository userrepo;

	public int add(Usermodel usermodel) {
		// TODO Auto-generated method stub
		UserEntity u = new UserEntity();
		u.setName(usermodel.getName());
		u.setEmail(usermodel.getEmail());
		return userrepo.save(u).hashCode();
	}

	@Override
	public int add(UserEntity usermodel) {
		// TODO Auto-generated method stub
		return userrepo.save(usermodel).hashCode();
	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

	@Override
	public UserEntity findOne(Long id) {
		// TODO Auto-generated method stub
		return userrepo.findByid(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userrepo.delete(userrepo.findByid(id));
	}

}
