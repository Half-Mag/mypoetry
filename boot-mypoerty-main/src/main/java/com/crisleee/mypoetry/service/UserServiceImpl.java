package com.crisleee.mypoetry.service;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;


import com.alibaba.dubbo.config.annotation.Service;
import com.cirsleee.mypoetry.bean.Poetry;
import com.cirsleee.mypoetry.bean.User;
import com.cirsleee.mypoetry.service.LoginService;

@Component
public class UserServiceImpl   {
    @Reference
	LoginService userservice;
	
	public boolean login1(int id,String password) {
		if(userservice.login(id,password)!=null) 
		   {return true;}
		
		else return false;
	 	}
	
	
	public boolean selectById(int id) {
		if(userservice.selectUserById(id)!=null)
			 return true;	
		
		else return false;
	}
	
	public User selectUserById(int id) {
		return userservice.selectUserById(id);
		
	}
	
	public List<Poetry> selectAll() {
		return userservice.selectAll();
	}

	public int selectHeatByName(String name) {
		return userservice.selectHeatByName(name);
	}

	public void likePoetry(String name) {
		userservice.likePoetry(name);
	}



}
	

