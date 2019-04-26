package com.alibaba.controller;

import com.alibaba.common.CustomException;
import com.alibaba.common.GlobalResponse;
import com.alibaba.entity.Admin;
import com.alibaba.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private MessageSource messageSource;


    /**
     * @function 认证功能
     * @param username
     * @param password
     * @return
     */
    //  http://localhost:8080/admin/login?username=xiaobai@qq.com&password=123456
    @RequestMapping("/login")
    public GlobalResponse login(String username, String password){
        Locale locale =  LocaleContextHolder.getLocale();
        // 使用shiro帮我完成认证
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(new UsernamePasswordToken(username,password));
            // 通过 主体获取身份信息
            String un = subject.getPrincipal().toString();
        }catch (Exception e){
            CustomException.pop(HttpStatus.BAD_REQUEST.value(),messageSource.getMessage("common.parameter.error",null,locale));
        }
        GlobalResponse globalResponse = new GlobalResponse();
        globalResponse.setCode(200);
        globalResponse.setMsg("");

        List<Admin> adminList = new ArrayList<>();
        Admin admin = new Admin();
        admin.setUsername("aaaa");
        admin.setPassword("123456");
        Admin admin1 = new Admin();
        admin1.setUsername("bbb");
        admin1.setPassword("456789");
       adminList.add(admin);
       adminList.add(admin1);

        globalResponse.setData(adminList);
        return globalResponse;
    }
    @RequestMapping("/test")
    @RequiresPermissions("role:create")
    public void test(){
        try{
            System.out.println("执行了授权！");
        }catch (Exception e){
            System.out.println("权限不够！！");
        }

    }
}
