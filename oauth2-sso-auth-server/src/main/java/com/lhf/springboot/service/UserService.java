package com.lhf.springboot.service;

import com.lhf.springboot.entity.SysUser;

/**
 * @ClassName: UserService
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/18 14:56
 */
public interface UserService {

    SysUser getByUsername(String username);
}
