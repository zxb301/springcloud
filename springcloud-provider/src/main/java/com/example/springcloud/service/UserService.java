package com.example.springcloud.service;


import com.example.springcloud.entity.SysUser;

public interface UserService {
    SysUser getUserById(Long id);
}
