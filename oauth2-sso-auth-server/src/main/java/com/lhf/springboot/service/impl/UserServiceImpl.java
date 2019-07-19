package com.lhf.springboot.service.impl;

import com.lhf.springboot.entity.SysUser;
import com.lhf.springboot.repository.SysUserRepository;
import com.lhf.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/18 15:05
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUser getByUsername(String username) {

        return sysUserRepository.findByUsername(username);
    }
}
