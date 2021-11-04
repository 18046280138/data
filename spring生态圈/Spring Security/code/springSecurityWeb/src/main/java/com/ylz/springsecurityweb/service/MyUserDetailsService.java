package com.ylz.springsecurityweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ylz.springsecurityweb.entity.Menu;
import com.ylz.springsecurityweb.entity.Role;
import com.ylz.springsecurityweb.entity.Users;
import com.ylz.springsecurityweb.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 登入时重写该方法获取用户名，权限
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //调用usersMapper方法，根据用户名查询数据库
        QueryWrapper<Users> wrapper = new QueryWrapper();
        // where username=?
        wrapper.eq("username",username);
        Users users = usersMapper.selectOne(wrapper);
        //判断
        if(users == null) {//数据库没有用户名，认证失败
            System.out.println("用户名不存在！");
            throw  new UsernameNotFoundException("用户名不存在！");
        }
        //获取用户角色，菜单列表
        List<Role> roleList = usersMapper.selectRoleByUserId(users.getId());
        List<Menu> menuList = usersMapper.selectMenuByUserId(users.getId());
        //声明一个集合
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        //处理角色
        for(Role role : roleList){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getName());
            grantedAuthorityList.add(simpleGrantedAuthority);
        }
        //处理权限
        for(Menu menu : menuList){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(menu.getName());
            grantedAuthorityList.add(simpleGrantedAuthority);
        }
        return new User(users.getUsername(),users.getPassword(),grantedAuthorityList);
//        List<GrantedAuthority> auths =
//                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_sale");
//        //从查询数据库返回users对象，得到用户名和密码，返回
////        return new User("gwj",
////                new BCryptPasswordEncoder().encode("123"),auths);
//        return new User(users.getUsername(),users.getPassword(),auths);
    }
}
