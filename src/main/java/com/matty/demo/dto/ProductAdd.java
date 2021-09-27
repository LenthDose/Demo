package com.matty.demo.dto;

import com.matty.demo.entity.CmsSubject;

import java.time.LocalDateTime;

public class ProductAdd {
    public static CmsSubject add(CmsSubjectParam cmsSubjectParam){
        CmsSubject cmsSubject = new CmsSubject();
        cmsSubject.setCategory_id(cmsSubjectParam.getCategory_id());
        cmsSubject.setCreateTime(LocalDateTime.now());
        cmsSubject.setDescription(cmsSubjectParam.getDescription());
        cmsSubject.setReadCount(cmsSubjectParam.getCount());
        cmsSubject.setTitle(cmsSubjectParam.getTitle());
        cmsSubject.setShowStatus(1);
        cmsSubject.setPic(cmsSubjectParam.getPic());
        return cmsSubject;
    }
}
