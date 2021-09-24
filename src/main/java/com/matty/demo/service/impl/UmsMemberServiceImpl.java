package com.matty.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.matty.demo.dto.UmsMemberRegister;
import com.matty.demo.entity.UmsMember;
import com.matty.demo.mapper.UmsMemberMapper;
import com.matty.demo.service.UmsMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author matty
 * @since 2021-09-17
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {

    @Autowired
    private UmsMemberService umsMemberService;


    @Override
    public String login(String username, String password) {
        QueryWrapper<UmsMember> wrapper = new QueryWrapper<>();
        UmsMember umsMember = umsMemberService.getOne(wrapper.eq("username",username));
        if (umsMember != null){
            if (umsMember.getPassword().equals(password)){
                return "登录成功";
            }
        }
         return null;
    }

    @Override
    public UmsMember register(String username, String password, int age, int gender, String phone) {
        if (umsMemberService.getById(username) != null) {
            return null;
        } else {
            UmsMember umsMember = UmsMemberRegister.setUmsMember(username, password, age, gender, phone);
            System.out.println(umsMemberService.save(umsMember));
            return umsMember;
        }
    }

    @Override
    public UmsMember getByOne(String username) {
        QueryWrapper<UmsMember> wrapper = new QueryWrapper<>();
        UmsMember umsMember = umsMemberService.getOne(wrapper.eq("username",username));
        return umsMember;
    }


}
