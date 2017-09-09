package com.hu.crm.service.impl;

import com.hu.crm.domain.Permission;
import com.hu.crm.domain.Role;
import com.hu.crm.mapper.RoleMapper;
import com.hu.crm.page.PageResult;
import com.hu.crm.query.RoleQueryObject;
import com.hu.crm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        int affectCount = roleMapper.insert(record);
        for (Permission permission : record.getPermissions()) {
            roleMapper.insertRelation(record.getId(), permission.getId());
        }
        return affectCount;
    }

    @Override
    public Role selectByPrimaryKey(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        int effectCount = roleMapper.updateByPrimaryKey(record);
        //先删除此角色和权限的关联关系
        roleMapper.deletePemissionById(record.getId());
        //重新维护中间表关系
        for (Permission permission : record.getPermissions()) {
            roleMapper.insertRelation(record.getId(), permission.getId());
        }
        return effectCount;
    }

    @Override
    public PageResult queryForPage(RoleQueryObject qo) {
        //查询结果数
        Long count = roleMapper.queryForPageCount(qo);
        if (count ==0){
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        //查询结果集
        List<Role> roles = roleMapper.queryForPage(qo);
        return new PageResult(count,roles);
    }


}
