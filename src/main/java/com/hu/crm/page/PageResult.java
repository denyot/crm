package com.hu.crm.page;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PageResult {
    private Long total;
    private List rows;

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }
}
