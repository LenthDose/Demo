package com.matty.demo.controller;


import com.matty.demo.api.CommonResult;
import com.matty.demo.entity.CmsSubject;
import com.matty.demo.service.CmsSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author matty
 * @since 2021-09-24
 */
@RestController
@RequestMapping(value = "api/product")
public class CmsSubjectController {
    @Autowired
    private CmsSubjectService cmsSubjectService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> showProduct(){
        List<CmsSubject> list = cmsSubjectService.list();
        return CommonResult.success(list);
    }

    @RequestMapping(value = "/study", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> studyProduct(){
        List<CmsSubject> list = cmsSubjectService.list(1);
        return CommonResult.success(list);
    }

    @RequestMapping(value = "/life", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> lifeProduct(){
        List<CmsSubject> list = cmsSubjectService.list(2);
        return CommonResult.success(list);
    }

    @RequestMapping(value = "/tech", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> techProduct(){
        List<CmsSubject> list = cmsSubjectService.list(3);
        return CommonResult.success(list);
    }

    @RequestMapping(value = "/cosm", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> cosmProduct(){
        List<CmsSubject> list = cmsSubjectService.list(4);
        return CommonResult.success(list);
    }

    @RequestMapping(value = "/other", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> otherProduct(){
        List<CmsSubject> list = cmsSubjectService.list(5);
        return CommonResult.success(list);
    }

}

