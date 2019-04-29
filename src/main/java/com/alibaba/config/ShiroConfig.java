package com.alibaba.config;

import com.alibaba.realm.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 *shiro的配置类
 */
@Configuration
public class ShiroConfig {

    /**
     * 配置shiro的拦截器链
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroChainConfig(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(getSecurityManager());
        shiroFilterFactoryBean.setLoginUrl("/jsp/login.jsp");
        Map<String,String> chainMap = new HashMap<>();
        chainMap.put("/admin/login","anon");
        chainMap.put("/admin/logout","logout");
        /*chainMap.put("/**","authc");*/
        shiroFilterFactoryBean.setFilterChainDefinitionMap(chainMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 安全管理器对象
     * @return
     */
    @Bean
    public DefaultWebSecurityManager getSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getRealm());
        return securityManager;
    }


    /**
     * realm对象
     * @return
     *
     */
    @Bean
    public MyRealm getRealm(){
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(getCredentialsMatcher());
        return myRealm;
    }

    /**
     * 凭证匹配器
     * @return
     */
    @Bean
    public HashedCredentialsMatcher getCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    /**
     *shiro注解授权的时候，开启注解授权
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(getSecurityManager());
        return authorizationAttributeSourceAdvisor;
    }


}

