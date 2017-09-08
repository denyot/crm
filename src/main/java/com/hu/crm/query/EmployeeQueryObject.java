package com.hu.crm.query;

import lombok.Getter;
import lombok.Setter;

/**
 * 封装员工查询条件
 */
@Getter
@Setter
public class EmployeeQueryObject extends QueryObject{
    private String keyword;
}
