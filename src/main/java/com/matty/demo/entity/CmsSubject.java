package com.matty.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Value;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author matty
 * @since 2021-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("cms_subject")
@ApiModel(value="CmsSubject对象", description="商品表")
public class CmsSubject implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Long category_id;

    private String title;

    @ApiModelProperty(value = "商品主图")
    private String pic;

    private LocalDateTime createTime = LocalDateTime.now();

    private Integer readCount;

    private String description;

    @ApiModelProperty(value = "显示状态：0->不显示；1->显示")
    private Integer showStatus = 1;

    private Long cid;

}
