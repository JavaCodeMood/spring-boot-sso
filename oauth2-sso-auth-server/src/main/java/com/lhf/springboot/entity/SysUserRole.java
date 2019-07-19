package com.lhf.springboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName: SysUserRole
 * @Author: liuhefei
 * @Description: 用户角色关联实体
 * @Date: 2019/7/18 11:56
 */
@Data
@Entity
@Table(schema = "permission", name = "sys_user_role")
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = -6622951694912580746L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "role_id")
    private Integer roleId;
}
