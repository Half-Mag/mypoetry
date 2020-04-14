package com.crisleee.mypoetry.Utils;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {
	@Resource
   public RedisTemplate<String, Object> redisTemplate;
	@Resource
	public StringRedisTemplate redisTemplate2;
	 /**
     * 指定缓存失效时间
     * @param key 键
     * @param time 时间(秒)
     * @return
     */
	 public boolean expire(String key, long time) {
	        try {
	            if (time > 0) {
	                redisTemplate2.expire(key, time, TimeUnit.SECONDS);
	            }
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 /**
	  * 获取键值
	  * 
	  * @param keys
	  * @return
	  */
	 public String keys(String keys){
		 return keys == null ? null : redisTemplate2.opsForValue().get(keys);}
	 /**
	     * 根据key 获取过期时间
	     * @param key 键 不能为null
	     * @return 时间(秒) 返回0代表为永久有效
	     */
	    public long getExpire(String key) {
	        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
	    }
	    
	    
	    
	    /**
	     * 判断key是否存在
	     * @param key 键
	     * @return true 存在 false不存在
	     */
	    public boolean hasKey(String key) {
	        try {
	            return redisTemplate2.hasKey(key);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    
	    /**
	     * 删除缓存
	     * @param key 可以传一个值
	     */
	 
	    public void del(String key) {
	        if (key != null ) {
	        	redisTemplate.delete(key);
	        }
	    }
	    
	    /**
	     * 数据放入缓存
	     * @param key 可以传一个值
	     */
	    public boolean set(String key, String value) {
	    	
	    	        try {redisTemplate2.opsForValue().set(key, value);
	    	               return true;	
	    	               } 	    	        
	    	        catch (Exception e) {	    	
	    	            e.printStackTrace();	    	
	    	            return false;
	    		    }	   }
}
