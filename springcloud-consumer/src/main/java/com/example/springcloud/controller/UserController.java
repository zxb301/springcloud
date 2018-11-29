package com.example.springcloud.controller;


import com.example.springcloud.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/user")
public class UserController {

    private static final String REST_URL_PREFIX = "http://SPRINGCOLUD-PROVIDER01";
   // private static final String REST_URL_PREFIX ="http://127.0.0.1:8090";
    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @GetMapping("/{id}")
   // @HystrixCommand(fallbackMethod = "hiError")
    public SysUser getUser(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/sys/" + id, SysUser.class);
    }
  /*  @ResponseBody
    public SysUser hiError(@PathVariable("id") Long id) {
        return new SysUser(1L,"王五",20);
    }*/
}