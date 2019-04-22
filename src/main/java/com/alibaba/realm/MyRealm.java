package com.alibaba.realm;

import com.alibaba.dao.AdminDao;
import com.alibaba.entity.Admin;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义realm  替换数据源
 */
public class MyRealm extends AuthenticatingRealm {
    @Autowired
    private AdminDao adminDao;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1. 根据token中的 账号 去数据查询是否存在
        // 获取token中的身份标识
        String username = authenticationToken.getPrincipal().toString();
        // 调用dao 执行查询
        Admin admin = adminDao.selectByUserName(username);
        if(admin != null){
            if(username.equals(admin.getUsername())){
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin.getUsername(),admin.getPassword(),
                        ByteSource.Util.bytes(admin.getPasswordsalt()),this.getName());
                return info;
            }
        }
        // 2. 如果存在 返回 info  如果不存在 返回null
        return null;
    }
}
