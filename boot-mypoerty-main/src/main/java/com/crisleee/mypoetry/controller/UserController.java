package com.crisleee.mypoetry.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cirsleee.mypoetry.bean.Heat;
import com.cirsleee.mypoetry.bean.Poetry;
import com.cirsleee.mypoetry.bean.PoetryCommond;
import com.cirsleee.mypoetry.bean.User;
import com.crisleee.mypoetry.service.PoetryRedisDaoImpl;
import com.crisleee.mypoetry.service.UserServiceImpl;


@Controller
public class UserController {
	@Autowired
	UserServiceImpl userservice;
	@Autowired
	PoetryRedisDaoImpl prd;
	
	@GetMapping("/login")
	public String  login(@RequestParam("userid")int id ,
    @RequestParam("password")String password,Model model,HttpSession httpsession) {
		    if( userservice.login1(id, password)) {
		    	User user= userservice.selectUserById(id);
		    	httpsession.setAttribute("id", user.getId());
				httpsession.setAttribute("password", user.getPassword());
		    	return "redirect:list"; }		 
    else {model.addAttribute("msg", "登陆失败，密码错误");}    	      	     	  
    return "main.html";  }
	
	
	
	

@GetMapping( "/list")
public String  list(Model model) {
	List<Poetry> list=userservice.selectAll();
	model.addAttribute("poetry", list);
    
	List<Heat> heat=new ArrayList<>();
	
    for(Poetry p:list) {
    	if(prd.hasKey(p.name)) {
    		heat.add(new Heat(p.name, Integer.parseInt(prd.get(p.name))));
    	}
    	else {
    		heat.add(new Heat(p.name,userservice.selectHeatByName(p.name)));
    	}
    }
	
	
	model.addAttribute("heat", heat);
	return "main.html";
}




@GetMapping("/like/{poetryname}")
public String like(@PathVariable("poetryname")String poetryname) {
	userservice.likePoetry(poetryname);
	prd.set(poetryname,String.valueOf(userservice.selectHeatByName(poetryname)));
	
	return "forward:/list";
}



}
