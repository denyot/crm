package com.hu.crm.service.impl;

import com.hu.crm.domain.Role;
import com.hu.crm.page.PageResult;
import com.hu.crm.query.RoleQueryObject;
import com.hu.crm.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(Role record) {
        return 0;
    }

    @Override
    public Role selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public List<Role> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return 0;
    }

    @Override
    public Role login(String username, String password) {
        return null;
    }

    @Override
    public PageResult queryForPage(RoleQueryObject qo) {
        return null;
    }

    @Override
    public void updateState(Long id) {

    }
}
