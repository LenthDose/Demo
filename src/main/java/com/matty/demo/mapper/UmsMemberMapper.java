package com.matty.demo.mapper;

import com.matty.demo.entity.UmsMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author matty
 * @since 2021-09-17
 */
@Mapper
public interface UmsMemberMapper extends BaseMapper<UmsMember> {

}
