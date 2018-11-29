package com.example.springcloud.mapper;

import com.example.springcloud.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {

    SysUser getUserById(Long id);
}
