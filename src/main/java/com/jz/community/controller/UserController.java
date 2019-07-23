package com.jz.community.controller;

import com.jz.community.domain.User;
import com.jz.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    @ResponseBody
    public String addData(){
        userService.save(new User("lei",10,"男"));
        userService.save(new User("lin",12,"男"));
        userService.save(new User("kn",30,"男"));
        return "success";
    }
}
