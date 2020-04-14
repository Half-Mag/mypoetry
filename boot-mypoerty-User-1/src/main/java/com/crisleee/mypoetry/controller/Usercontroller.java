package com.crisleee.mypoetry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cirsleee.mypoetry.bean.User;
import com.crisleee.mypoetry.mapper.UserMapper;

@RestController
public class Usercontroller {
    @Autowired
    UserMapper usermapper;
	

	
	@GetMapping("/user/{id}")
	
	public User selectUserById(@PathVariable("id") int id) {
		return usermapper.searchUserById(id);
	}
	
}
