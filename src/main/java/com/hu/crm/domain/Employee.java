package com.hu.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Employee {
    private Long id;

    private String username;//用户名

    private String realname;//真实姓名

    private String password;//密码

    private String tel;//电话

    private String email;//邮箱

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputtime;//入职时间

    private Boolean admin;//是否超级管理员

    private Boolean state;//在职状态
    private Department dept;//部门
    private List<Role> roles = new ArrayList<>();


}