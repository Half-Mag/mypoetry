package com.crisleee.mypoetry.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.cirsleee.mypoetry.bean.PoetryCommond;
import com.cirsleee.mypoetry.service.PoetryDao;

@Service
@Component
public class PoetryDaoImpl implements PoetryDao {
	@Autowired
    private MongoTemplate mongoTemplate;
	
	@Override
	public void addCommond(String poetryname,PoetryCommond poetry) {
		if(mongoTemplate.collectionExists(poetryname)) 
		{ mongoTemplate.insert(poetry,poetryname);}
		else { mongoTemplate.createCollection(poetryname);
		 mongoTemplate.insert(poetry,poetryname);
		
		}
		
	}

	@Override
	public List<PoetryCommond> selectCommond(PoetryCommond poetry,String name) {
		List<PoetryCommond> list=mongoTemplate.findAll(PoetryCommond.class, name);
		return list;
		
	}

	@Override
	public void deleteCommond(PoetryCommond poetry) {
		
		
	}

}
