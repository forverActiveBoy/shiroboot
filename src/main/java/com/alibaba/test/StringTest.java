package com.alibaba.test;

public class StringTest {
    public static void main(String[] args) {
        String s = "http://localhost:8080/admin/activity/add";
       String newS =  s.substring(0,s.lastIndexOf("admin"));
        System.out.println(newS);
    }
}
