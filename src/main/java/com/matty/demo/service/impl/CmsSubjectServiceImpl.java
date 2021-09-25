package com.matty.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.matty.demo.entity.CmsSubject;
import com.matty.demo.mapper.CmsSubjectMapper;
import com.matty.demo.service.CmsSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author matty
 * @since 2021-09-24
 */
@Service
public class CmsSubjectServiceImpl extends ServiceImpl<CmsSubjectMapper, CmsSubject> implements CmsSubjectService {

    @Autowired
    private CmsSubjectService subjectService;

    @Override
    public List<CmsSubject> list(Integer categoryId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("category_id",categoryId);
        List<CmsSubject> list = subjectService.list(wrapper);
        return list;
    }
}
