package com.example.springcloud.service;


import com.example.springcloud.component.SchedualServiceHiHystric;
import com.example.springcloud.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "SPRINGCOLUD-PROVIDER02" ,fallback = SchedualServiceHiHystric.class)
public interface MyUserService {
    @RequestMapping(value = "/sys/{id}", method = RequestMethod.GET)
    SysUser getUser(@PathVariable("id") Long id);

}
