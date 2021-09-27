package com.matty.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UmsMemberRegisterParam {

    @NotEmpty
    @ApiModelProperty(value = "用户名",required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "密码",required = true)
    private String password;

    @NotEmpty
    @ApiModelProperty(value = "年龄",required = true)
    private int age;

    @NotEmpty
    @ApiModelProperty(value = "性别",required = true)
    private int gender;

    @NotEmpty
    @ApiModelProperty(value = "电话",required = true)
    private String phone;

    @NotEmpty
    @ApiModelProperty(value = "地址",required = true)
    private String address;
}
