package com.crisleee.mypoetry.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cirsleee.mypoetry.bean.Poetry;
import com.cirsleee.mypoetry.bean.User;
@Mapper
//操作用户数据库的操作
public interface UserMapper {
    @Select("select * from user where id=#{id}")
	public User searchUserById(int id);
    @Select("select * from poetry")
    public List<Poetry> searchAll();
    
    @Select("select heat from poetry where name=#{name}")
   	public Integer selectHeatByName(String name);
    
    @Update("update poetry set heat=heat+10 where name=#{name}")
    public void likePoetry(String name);
    
}
