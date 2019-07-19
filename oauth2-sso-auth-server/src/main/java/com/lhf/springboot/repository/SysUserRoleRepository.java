package com.lhf.springboot.repository;

import com.lhf.springboot.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @ClassName: SysUserRoleRepository
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/18 15:18
 */
public interface SysUserRoleRepository extends JpaSpecificationExecutor<SysUserRole>, JpaRepository<SysUserRole, Integer> {

    List<SysUserRole> findByUserId(Integer userId);
}
