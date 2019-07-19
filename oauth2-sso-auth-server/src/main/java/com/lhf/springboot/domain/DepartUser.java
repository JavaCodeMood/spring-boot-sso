package com.lhf.springboot.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @ClassName: MyUser
 * @Author: liuhefei
 * @Description: 大部分时候直接用User即可不必扩展
 * @Date: 2019/7/18 11:28
 */
@Data
public class DepartUser extends User {

    private Integer departmentId;  //部门ID

    private String mobile;  //假设我们想增加一个字段，这里我们增加一个mobile表示手机号

    public DepartUser(String username, String password, Collection<? extends GrantedAuthority> authorities){
        super(username, password, authorities);
    }

    public DepartUser(String username, String password, boolean enabled, boolean accountNonExpired,
                      boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities){
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
