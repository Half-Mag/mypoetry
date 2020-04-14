package com.crisleee.mypoetry.service;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cirsleee.mypoetry.bean.PoetryCommond;
import com.cirsleee.mypoetry.service.PoetryDao;
@Component
public class poetryCommondService {
 @Reference
PoetryDao poetrydao;

public void addCommond1(PoetryCommond pc,String poetryname ) {		
	poetrydao.addCommond(poetryname,pc);	
}

public List<PoetryCommond> checkcommond1(PoetryCommond p,String name){
	List<PoetryCommond> list=poetrydao.selectCommond(p, name);
	return list;
}

}