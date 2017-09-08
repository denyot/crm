package com.hu.crm.mapper;

import com.hu.crm.domain.Permission;
import com.hu.crm.query.PermissionQueryObject;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);
    List<Permission> queryForPage(PermissionQueryObject qo);

    Long queryForPageCount(PermissionQueryObject qo);
}