package com.hu.crm.query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeQueryObject {
    private Long page;
    private Long rows;

    public Long getStart() {
        return (this.page - 1) * rows;

    }
}
