package com.atguigu.springboot.service;

import com.atguigu.springboot.entities.User;
import com.atguigu.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean UserLogin(User user){
        User isExit =  userMapper.userExit(user);
        return isExit != null;
    }

    public void InsertUser(User user){
        Integer result = userMapper.InsertUser(user);
        System.out.println(result.toString());
    }

    public Boolean UserisExist(User user){
        User isExit =  userMapper.userExit(user);
        return isExit!=null;
    }
}
