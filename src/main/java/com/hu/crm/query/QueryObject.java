package com.hu.crm.query;

import lombok.Getter;
import lombok.Setter;

/**
 * 基础分页查询
 */
@Getter
@Setter
public class QueryObject {
    protected Long page;
    protected Long rows;
    public Long getStart() {
        return (this.page - 1) * rows;
    }
}
