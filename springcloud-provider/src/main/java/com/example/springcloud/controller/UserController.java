package com.example.springcloud.controller;

import com.example.springcloud.entity.SysUser;
import com.example.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sys")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/{id}")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "hiError")
    public SysUser getUser(@PathVariable("id") Long id){
       SysUser sysUser= userService.getUserById(id);
        if (null == sysUser) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }

        return  sysUser;
    }

    @ResponseBody
    public SysUser hiError(@PathVariable("id") Long id) {
        return new SysUser(1L,"王五",30);
    }


    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("SPRINGCOLUD-PROVIDER");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }
}
