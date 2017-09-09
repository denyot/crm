package com.hu.crm.service;

import com.hu.crm.domain.Role;
import com.hu.crm.page.PageResult;
import com.hu.crm.query.RoleQueryObject;

import java.util.List;

public interface IRoleService {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    PageResult queryForPage(RoleQueryObject qo);


}
