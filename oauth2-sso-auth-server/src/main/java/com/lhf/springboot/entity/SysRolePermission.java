package com.lhf.springboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName: SysRolePermission
 * @Author: liuhefei
 * @Description: 角色权限关联实体
 * @Date: 2019/7/18 11:51
 */
@Data
@Entity
@Table(schema = "permission", name = "sys_role_permission")
public class SysRolePermission implements Serializable {

    private static final long serialVersionUID = 7158709624791288475L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "permission_id")
    private Integer permissionId;
}
