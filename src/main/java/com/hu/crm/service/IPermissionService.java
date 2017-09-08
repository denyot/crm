package com.hu.crm.service;

import com.hu.crm.domain.Permission;
import com.hu.crm.page.PageResult;
import com.hu.crm.query.PermissionQueryObject;

import java.util.List;

public interface IPermissionService {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);


    PageResult queryForPage(PermissionQueryObject qo);


}
