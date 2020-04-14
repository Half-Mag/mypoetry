package com.crisleee.mypoetry.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cirsleee.mypoetry.bean.PoetryCommond;
import com.crisleee.mypoetry.service.poetryCommondService;

@Controller
public class PoetryController {
	
	@Autowired 
	poetryCommondService pcs;
	/**
	 * 
	 * 这部分是mongodb对评论功能实现的相关控制器
	 *
	 *
	 * 
	 */
	@GetMapping("/commond/{name}")
	public String toaddCommond(@PathVariable("name")String name,Model model)	
	{	model.addAttribute("poetryname11",name);		
		return "addcommond.html";
	}
	
	
	
	@GetMapping("/addcommond/{poetryname}")
	public String addCommond(@PathVariable("poetryname")String poetryname,HttpSession session,@RequestParam("words")String words ) {
		
		PoetryCommond PC=new PoetryCommond();
		PC.setUserid((int) session.getAttribute("id"));
		PC.setCommond(words);
		pcs.addCommond1(PC,poetryname);
		return "/list";
	}
	
	@GetMapping("/checkcommond/{poetryname}")
	public String checkcommond(@PathVariable("poetryname")String poetryname,Model model,PoetryCommond p) {
		List<PoetryCommond> list=pcs.checkcommond1(p, poetryname);
		model.addAttribute("commond",list);
		return "commond.html";
	}
	
	
	
	
	
	
	
	
	
	/**以下是redis作为缓存的相关控制器
	 * 
	 * 
	 * 
	 */
 
	
	
	
	
}