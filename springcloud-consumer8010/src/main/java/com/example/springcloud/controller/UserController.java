package com.example.springcloud.controller;

import com.example.springcloud.entity.SysUser;
import com.example.springcloud.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MyUserService myUserService;
    @GetMapping("/{id}")
    @ResponseBody
    public SysUser getUser(@PathVariable("id") Long id) {
        return this.myUserService.getUser(id);
    }

   /*
    private static final String REST_URL_PREFIX = "http://SPRINGCOLUD-PROVIDER";
   // private static final String REST_URL_PREFIX ="http://127.0.0.1:8090";
    @Autowired
    private RestTemplate restTemplate;


    @ResponseBody
    @GetMapping("/{id}")
    public SysUser getUser(@PathVariable("id") Long id) {

        return restTemplate.getForObject(REST_URL_PREFIX + "/sys/" + id, SysUser.class);
    }
    */

}