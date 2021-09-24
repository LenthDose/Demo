package com.matty.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UmsMemberLoginParam {

    @NotEmpty
    @ApiModelProperty(value = "用户名",required = true)
    String username;

    @NotEmpty
    @ApiModelProperty(value = "密码",required = true)
    private String password;

}
