package com.matty.demo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class CmsSubjectParam {

    @NotEmpty
    private Long category_id;

    @NotEmpty
    private String title;

    @ApiModelProperty(value = "商品主图")
    private String pic;

    private LocalDateTime createTime;

    private Integer count;

    private String description;

    @ApiModelProperty(value = "显示状态：0->不显示；1->显示")
    private Integer showStatus;
}
