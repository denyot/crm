package com.hu.crm.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//测试分支
//再次测试分支
public class Department {
    private Long id;

    private String sn;//编码

    private String name;//名称

    private Boolean state;//状态

    private Department parent;//上级部门

    private Employee manager;//部门管理

}