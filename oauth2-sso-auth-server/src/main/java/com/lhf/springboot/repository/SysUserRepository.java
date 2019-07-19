package com.lhf.springboot.repository;

import com.lhf.springboot.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName: SysUserRepository
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/18 15:08
 */
public interface SysUserRepository extends JpaSpecificationExecutor<SysUser>, JpaRepository<SysUser, Integer> {

    SysUser findByUsername(String username);
}
