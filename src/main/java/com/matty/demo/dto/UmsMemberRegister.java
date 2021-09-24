package com.matty.demo.dto;

import com.matty.demo.entity.UmsMember;

import java.time.LocalDateTime;

public class UmsMemberRegister {

    public static  UmsMember setUmsMember(String username, String password, int age, int gender, String phone){
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername(username);
        umsMember.setPassword(password);
        umsMember.setAge(age);
        umsMember.setGender(gender);
        umsMember.setPhone(phone);
        umsMember.setStatus(1);
        umsMember.setCreateTime(LocalDateTime.now());
        return umsMember;
    };

}
