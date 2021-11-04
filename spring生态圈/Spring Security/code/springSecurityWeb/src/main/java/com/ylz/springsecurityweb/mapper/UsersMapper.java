package com.ylz.springsecurityweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ylz.springsecurityweb.entity.Menu;
import com.ylz.springsecurityweb.entity.Role;
import com.ylz.springsecurityweb.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersMapper extends BaseMapper<Users> {
    /**
     * 根据用户 Id 查询用户角色
     * @param userId
     * @return
     */
    List<Role> selectRoleByUserId(Long userId);
    /**
     * 根据用户 Id 查询菜单
     * @param userId
     * @return
     */
    List<Menu> selectMenuByUserId(Long userId);
}
