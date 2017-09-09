package com.hu.crm.mapper;

import com.hu.crm.domain.Role;
import com.hu.crm.query.RoleQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    void insertRelation(@Param("rid") Long rid, @Param("pid") Long pid);

    Long queryForPageCount(RoleQueryObject qo);

    List<Role> queryForPage(RoleQueryObject qo);

    void deletePemissionById(Long rid);

}