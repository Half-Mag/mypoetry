package com.crisleee.mypoetry.Dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.cirsleee.mypoetry.service.PoetryRedisDao;
import com.crisleee.mypoetry.Utils.RedisUtils;
@Service
@Component
public class PoetryRedisDaoImpl  implements PoetryRedisDao{
    @Autowired
	RedisUtils util;
	
	@Override
	public boolean hasKey(String key) {
		return util.hasKey(key);

			
	}

	@Override
	public void set(String key,String value) {
		util.set(key,value);
		
	}
 
	@Override
	public String getKey(String key) {
		
		return util.keys(key);
	} 

	@Override
	public void deleteKey(String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTime(String key, long time) {
		util.expire(key, time);
		
	}

}
