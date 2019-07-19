package com.lhf.springboot.service.impl;

import com.lhf.springboot.entity.SysPermission;
import com.lhf.springboot.entity.SysRolePermission;
import com.lhf.springboot.entity.SysUserRole;
import com.lhf.springboot.repository.SysPermissionRepository;
import com.lhf.springboot.repository.SysRolePermissionRepository;
import com.lhf.springboot.repository.SysUserRoleRepository;
import com.lhf.springboot.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: PermissionServiceImpl
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/18 15:06
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;

    @Autowired
    private SysRolePermissionRepository sysRolePermissionRepository;

    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    @Override
    public List<SysPermission> findByUserId(Integer userId) {
        List<SysUserRole> sysUserRoleList = sysUserRoleRepository.findByUserId(userId);
        if(CollectionUtils.isEmpty(sysUserRoleList)){
            return null;
        }

        List<Integer> roleIdList = sysUserRoleList.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        List<SysRolePermission> rolePermissionList = sysRolePermissionRepository.findByRoleIds(roleIdList);
        if(CollectionUtils.isEmpty(rolePermissionList)){
            return null;
        }

        List<Integer> permissionIdList = rolePermissionList.stream().map(SysRolePermission::getPermissionId).distinct().collect(Collectors.toList());
        List<SysPermission> sysPermissionList = sysPermissionRepository.findByIds(permissionIdList);
        if(CollectionUtils.isEmpty(sysPermissionList)){
            return null;
        }

        return sysPermissionList;
    }
}
