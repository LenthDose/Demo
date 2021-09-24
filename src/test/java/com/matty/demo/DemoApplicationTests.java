package com.matty.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.matty.demo.entity.UmsMember;
import com.matty.demo.mapper.UmsMemberMapper;
import com.matty.demo.service.UmsMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UmsMemberService umsMemberService;

    @Test
    public void login(){
        QueryWrapper<UmsMember> wrapper = new QueryWrapper<>();
        UmsMember umsMember = umsMemberService.getOne(wrapper.eq("username","ad"));
        if (umsMember != null){
            if (umsMember.getPassword().equals("123456")){
                System.out.println("success");
                System.out.println(umsMember.getUsername()+umsMember.getPassword());
            }
        }
        else {
            System.out.println("fail");
        }
    }
}
