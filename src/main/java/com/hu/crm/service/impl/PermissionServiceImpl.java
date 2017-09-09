package com.hu.crm.service.impl;

import com.hu.crm.domain.Permission;
import com.hu.crm.mapper.PermissionMapper;
import com.hu.crm.page.PageResult;
import com.hu.crm.query.PermissionQueryObject;
import com.hu.crm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Permission record) {
        return permissionMapper.insert(record);
    }

    @Override
    public Permission selectByPrimaryKey(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Permission> selectAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return permissionMapper.updateByPrimaryKey(record);
    }


    @Override
    public PageResult queryForPage(PermissionQueryObject qo) {
        //查询结果数
        Long count = permissionMapper.queryForPageCount(qo);
        if (count ==0){
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        //查询结果集
        List<Permission> permissions = permissionMapper.queryForPage(qo);
        return new PageResult(count,permissions);
    }
}
