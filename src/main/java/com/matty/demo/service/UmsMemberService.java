package com.matty.demo.service;

import com.matty.demo.api.CommonResult;
import com.matty.demo.dto.UmsMemberRegisterParam;
import com.matty.demo.entity.UmsMember;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author matty
 * @since 2021-09-17
 */
public interface UmsMemberService extends IService<UmsMember> {

    String login(String username, String password);

    UmsMember register(String username, String password, int age, int gender, String phone, String address);

    UmsMember getByOne(String username);

    UmsMember updateByUser(UmsMember umsMember);
}
