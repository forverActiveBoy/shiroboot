package com.alibaba.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Test {
    public static void main(String[] args) {
        DigestUtils.md5("123456");
    }
}
