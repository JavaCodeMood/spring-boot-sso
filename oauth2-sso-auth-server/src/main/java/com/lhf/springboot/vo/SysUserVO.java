package com.lhf.springboot.vo;

import com.lhf.springboot.entity.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: SysUserVO
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/18 11:35
 */
@Data
public class SysUserVO extends SysUser {

    /**
     * 权限列表
     */
    private List<String> authorityList;
}
