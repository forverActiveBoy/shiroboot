package com.alibaba.realm;

import com.alibaba.dao.AdminDao;
import com.alibaba.dao.ResourceDao;
import com.alibaba.entity.Admin;
import com.alibaba.entity.Resource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义realm  替换数据源
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private ResourceDao resourceDao;
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

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //  获取账号
        String username = (String) principals.getPrimaryPrincipal();
        //  根据账号，查询出角色id
        //  根据角色id，查询出角色name
        //  根据角色name，查询资源id
        //  根据资源id查询资源集合
        List<Resource> resourceList = resourceDao.selectResource();
        List<String> permissionList = new ArrayList<>();
        for (Resource resource:resourceList) {
            permissionList.add(resource.getRescode());
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissionList);
        return simpleAuthorizationInfo;
    }
}
