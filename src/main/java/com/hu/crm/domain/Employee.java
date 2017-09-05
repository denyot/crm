package com.hu.crm.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Employee {
    private Long id;

    private String username;//用户名

    private String realname;//真实姓名

    private String password;//密码

    private String tel;//电话

    private String email;//邮箱

    private Department dept;//部门

    private Date inputtime;//入职时间

    private Boolean admin;//是否超级管理员

    private Boolean state;//在职状态

}