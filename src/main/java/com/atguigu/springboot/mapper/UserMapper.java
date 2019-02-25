package com.atguigu.springboot.mapper;

import com.atguigu.springboot.entities.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Mapper
public interface UserMapper {

    @Select("select *from user where username=#{username} and password=#{password}")
    public User userExit(User user);


    @Insert("insert into user (username,password) values (#{username},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "Id",keyColumn = "id")
    public int InsertUser(User user);

    @Insert("INSERT INTO USER(id,username,password) VALUES(#{id},#{username},#{password})")
    int insert(@Param("id")Integer id,@Param("username") String name,@Param("password") String password);



}
