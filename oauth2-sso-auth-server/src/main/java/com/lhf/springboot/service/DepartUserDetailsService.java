package com.lhf.springboot.service;

import com.alibaba.fastjson.JSON;
import com.lhf.springboot.domain.DepartUser;
import com.lhf.springboot.entity.SysPermission;
import com.lhf.springboot.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @ClassName: DepartUserDetailsService
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/18 14:53
 */
@Slf4j
@Service
public class DepartUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userService.getByUsername(username);
        if(null == sysUser){
            log.warn("用户 {} 不存在", username);
            throw new UsernameNotFoundException(username);
        }
        List<SysPermission> permissionList = permissionService.findByUserId(sysUser.getId());
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(permissionList)){
            for(SysPermission sysPermission : permissionList){
                authorityList.add(new SimpleGrantedAuthority(sysPermission.getCode()));
            }
        }

        DepartUser departUser = new DepartUser(sysUser.getUsername(), passwordEncoder.encode(sysUser.getPassword()), authorityList);
        log.info("登陆成功！ 用户： {}", JSON.toJSONString(departUser));

        return departUser;
    }
}
