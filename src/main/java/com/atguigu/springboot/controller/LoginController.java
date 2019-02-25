package com.atguigu.springboot.controller;

import com.atguigu.springboot.entities.User;
import com.atguigu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @DeleteMapping
//    @PutMapping
//    @GetMapping

    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @Autowired
    UserService userService;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        User user = new User(username,password);
        boolean result =  userService.UserLogin(user);

        if(result){
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            //登陆失败
            map.put("msg","用户名密码错误");
            return  "login";
        }
    }

    @PostMapping(value = "/user/register")
    public String register(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map){

        User user = new User(username,password);
        boolean result =  userService.UserisExist(user);

        if(!result){
            //登陆成功，防止表单重复提交，可以重定向到主页
            userService.InsertUser(user);
            return "redirect:/";// 回到登录页
        }else{
            //登陆失败
            map.put("msg","用户已经存在");
            return  "register";
        }
    }

    @GetMapping(value = "register")
    public String register(){
        return "register";
    }
}
