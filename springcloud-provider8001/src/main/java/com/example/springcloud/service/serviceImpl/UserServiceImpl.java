package com.example.springcloud.service.serviceImpl;

import com.example.springcloud.entity.SysUser;

import com.example.springcloud.mapper.SysUserMapper;
import com.example.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserById(Long id) {
        return sysUserMapper.getUserById(id);
    }
}
