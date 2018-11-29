package com.example.springcloud.component;

import com.example.springcloud.entity.SysUser;
import com.example.springcloud.service.MyUserService;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements MyUserService {

    @Override
    public SysUser getUser(Long id) {
        return new SysUser(2L,"小米",35);
    }
}

