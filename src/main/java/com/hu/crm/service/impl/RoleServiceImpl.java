package com.hu.crm.service.impl;

import com.hu.crm.domain.Permission;
import com.hu.crm.domain.Role;
import com.hu.crm.mapper.RoleMapper;
import com.hu.crm.page.PageResult;
import com.hu.crm.query.RoleQueryObject;
import com.hu.crm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<Permission> permissions = record.getPermissions();
        for (Permission permission : permissions) {
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
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryForPage(RoleQueryObject qo) {
        return null;
    }


}
