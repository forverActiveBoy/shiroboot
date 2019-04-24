package com.alibaba.realm;

import com.alibaba.dao.*;
import com.alibaba.entity.Admin;
import com.alibaba.entity.AmdinRole;
import com.alibaba.entity.Role;
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
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义realm  替换数据源
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private AmdinRoleDao amdinRoleDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RoleResourceDao roleResourceDao;
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
        //  获取该系统登录账号
        String username = (String) principals.getPrimaryPrincipal();
        //  根据账号，查询出角色id
        AmdinRole amdinRole = new AmdinRole();
        amdinRole.setUsername(username);
        AmdinRole getAdminRole =  amdinRoleDao.selectAmdinRoleByObj(amdinRole);
        Integer roleId = getAdminRole.getRoleid();
        //  根据角色id，查询出角色name
        Role role = new Role();
        role.setId(roleId);
        Role getRole =  roleDao.selectRoleByObj(role);
        String roleName = getRole.getRolename();
        //  根据角色name，查询资源id
        List<Integer> resIds =  roleResourceDao.selectResIdByRoleName(roleName);
        //  根据资源id查询资源集合
        Set<String> resourceCodeList = resourceDao.selectResCodeByResId(resIds);
        Set<String> newResourcesCodeList = new HashSet<>();
        //非空判断  一定要进行非空判断，否则会报错
        for (String s:resourceCodeList) {
            if(!StringUtils.isEmpty(s)){
                newResourcesCodeList.add(s);
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //  添加权限集合
        simpleAuthorizationInfo.addStringPermissions(resourceCodeList);
        return simpleAuthorizationInfo;
    }
}
