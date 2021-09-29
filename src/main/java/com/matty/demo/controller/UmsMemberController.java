package com.matty.demo.controller;


import com.matty.demo.api.CommonResult;
import com.matty.demo.dto.UmsMemberLoginParam;
import com.matty.demo.dto.UmsMemberRegisterParam;
import com.matty.demo.entity.UmsMember;
import com.matty.demo.service.UmsMemberService;
import com.matty.demo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author matty
 * @since 2021-09-17
 */
@RestController
@RequestMapping("api")
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @Autowired
    private TokenUtil tokenUtil;


    @CrossOrigin
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsMemberLoginParam umsMemberLoginParam){
        UmsMember umsMember = umsMemberService.login(umsMemberLoginParam);
        if (umsMember == null){
            return CommonResult.failed();
        }
        return CommonResult.success(umsMember);
    }

    @CrossOrigin
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsMember> register(@RequestBody UmsMemberRegisterParam registerParam){
        UmsMember umsMember = umsMemberService.register(registerParam.getUsername(),registerParam.getPassword(),registerParam.getAge(),
                registerParam.getGender(),registerParam.getPhone());
        if (umsMember == null){
            return CommonResult.failed();
        }
        return CommonResult.success(umsMember);
    }

    @CrossOrigin
    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<UmsMember> personal(@RequestParam String username){
        UmsMember umsMember = umsMemberService.getByOne(username);
        if (umsMember == null){
            return CommonResult.failed();
        }
        return CommonResult.success(umsMember);
    }

    @CrossOrigin
    @RequestMapping(value = "/resetUser",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsMember> resetUser(@RequestBody UmsMember umsMember){
        boolean is = umsMemberService.updateById(umsMember);
        if (is){
            return CommonResult.success(umsMember);
        }
        return CommonResult.failed();
    }



}

