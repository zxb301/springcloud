package com.example.springcloud.controller;

import com.example.springcloud.entity.SysUser;
import com.example.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    @ResponseBody
    public SysUser getUser(@PathVariable("id") Long id){
       SysUser sysUser= userService.getUserById(id);
       return  sysUser;
    }

}
