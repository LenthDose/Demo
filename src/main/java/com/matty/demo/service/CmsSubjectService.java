package com.matty.demo.service;

import com.matty.demo.entity.CmsSubject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author matty
 * @since 2021-09-24
 */
public interface CmsSubjectService extends IService<CmsSubject> {

    List<CmsSubject> list(Integer categoryId);





}
