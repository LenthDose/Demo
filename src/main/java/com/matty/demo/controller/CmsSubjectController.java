package com.matty.demo.controller;


import com.matty.demo.api.CommonResult;
import com.matty.demo.entity.CmsSubject;
import com.matty.demo.entity.UmsMember;
import com.matty.demo.service.CmsSubjectService;
import com.matty.demo.service.UmsMemberService;
import com.matty.demo.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @RequestMapping(value = "/list/category", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> ProductByCategoryId(@RequestParam(value = "categoryid") Integer categoryId){
        List<CmsSubject> list = cmsSubjectService.list(categoryId);
        return CommonResult.success(list);
    }


    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> ProductList(){
        List<CmsSubject> list = cmsSubjectService.list();
        return CommonResult.success(list);
    }


    @CrossOrigin
    @PostMapping("/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "C:\\Users\\Silhouette76\\Desktop\\Demo\\src\\main\\resources\\img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8090/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CmsSubject> add(@RequestBody CmsSubject cmsSubject){
        boolean is = cmsSubjectService.save(cmsSubject);
        if(is){
            return CommonResult.success(cmsSubject);
        }
        return CommonResult.failed();
    }



}

