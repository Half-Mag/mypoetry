package com.crisleee.mypoetry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alibaba.dubbo.config.annotation.Service;
import com.cirsleee.mypoetry.bean.Poetry;
import com.cirsleee.mypoetry.bean.User;
import com.cirsleee.mypoetry.service.LoginService;
import com.crisleee.mypoetry.mapper.UserMapper;


@Service
@Component
public class userService implements LoginService{
	  @Autowired
	    UserMapper usermapper;
		
		
	
		
		
		public User  selectUserById(int id) {
			return usermapper.searchUserById(id);
		}



		@Override
		public User login(int id, String password) {
			
			return usermapper.searchUserById(id);
		}



		@Override
		public List<Poetry> selectAll() {
			return usermapper.searchAll();
			
		}



		@Override
		public int selectHeatByName(String name) {
			return usermapper.selectHeatByName(name).intValue();
		}



		@Override
		public void likePoetry(String name) {
			usermapper.likePoetry(name);
			
		}



		
}
