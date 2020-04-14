package com.crisleee.mypoetry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cirsleee.mypoetry.service.PoetryRedisDao;
@Component
public class PoetryRedisDaoImpl {
	@Reference
	PoetryRedisDao prd;
	
	//查询key值
	public String get(String key) {
		return prd.getKey(key);
		
	}
	
	//查询key是否存在（key是否过期）
	public boolean hasKey(String key) {
	return 	prd.hasKey(key);
		}
	
	
	//设置过期时间
	public void setTime(String key) {
		prd.setTime(key, 5L);
		
	}
	
	
	//设置键值
	public void set(String key,String value) {
		prd.set(key, value);
	}
	
	
	
}
