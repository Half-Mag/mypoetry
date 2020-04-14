package com.crisleee.mypoetry;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cirsleee.mypoetry.bean.PoetryCommond;

import com.crisleee.mypoetry.Dao.PoetryDaoImpl;
import com.crisleee.mypoetry.Dao.PoetryRedisDaoImpl;
import com.jayway.jsonpath.internal.Utils;

@SpringBootTest
class BootMypoetryPoetryApplicationTests {
	@Autowired
	PoetryRedisDaoImpl prd;
	
	@Test
	void contextLoads() {	
	
	System.out.println("===========================================================");
	System.out.println(prd.hasKey("qqq"));
	prd.setTime("qqq", 10);
	prd.set("asd", "aseqweqwe");
	
	
	}

	
}
