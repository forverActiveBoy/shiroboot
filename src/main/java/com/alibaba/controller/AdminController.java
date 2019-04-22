package com.alibaba.controller;

import com.alibaba.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    // http://localhost:8080/admin/login.do?username=xiaobai@qq.com&password=123456
    @RequestMapping("/login")
    public String login(String username, String password){
        // 使用shiro帮我完成认证
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(new UsernamePasswordToken(username,password));
            // 通过 主体获取身份信息
            String un = subject.getPrincipal().toString();
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "ok";
    }
}
