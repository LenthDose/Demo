package com.matty.demo.controller;


import com.matty.demo.api.CommonResult;
import com.matty.demo.dto.UmsMemberLoginParam;
import com.matty.demo.dto.UmsMemberRegisterParam;
import com.matty.demo.entity.UmsMember;
import com.matty.demo.service.UmsMemberService;
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

    @CrossOrigin
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsMemberLoginParam umsMemberLoginParam){
        String result = umsMemberService.login(umsMemberLoginParam.getUsername(), umsMemberLoginParam.getPassword());
        if (result == null){
            return CommonResult.failed();
        }
        return CommonResult.success(result);
    }

    @CrossOrigin
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestBody UmsMemberRegisterParam registerParam){
        UmsMember umsMember = umsMemberService.register(registerParam.getUsername(),registerParam.getPassword(),registerParam.getAge(),
                registerParam.getGender(),registerParam.getPhone(),registerParam.getAddress());
        if (umsMember == null){
            return CommonResult.failed();
        }
        return CommonResult.success(umsMember);
    }

    @CrossOrigin
    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult personal(@RequestParam String username){
        UmsMember umsMember = umsMemberService.getByOne(username);
        if (umsMember == null){
            return CommonResult.failed();
        }
        return CommonResult.success(umsMember);
    }

    @RequestMapping(value = "/resetUser",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult resetUser(@RequestBody UmsMember umsMember){
        UmsMember member =  umsMemberService.updateByUser(umsMember);
        if (member != null){
            return CommonResult.success(umsMember);
        }
        return CommonResult.failed();
    }

}

