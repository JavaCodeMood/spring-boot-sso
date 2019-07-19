package com.lhf.springboot.service;

import com.lhf.springboot.entity.SysPermission;

import java.util.List;

/**
 * @ClassName: PermissionService
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/18 14:57
 */
public interface PermissionService {

    List<SysPermission> findByUserId(Integer userId);
}
