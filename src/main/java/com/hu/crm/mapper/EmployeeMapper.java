package com.hu.crm.mapper;

import com.hu.crm.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    Employee login(@Param("username") String username, @Param("password") String password);

}