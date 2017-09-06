package com.hu.crm.service;

import com.hu.crm.domain.Employee;

import java.util.List;
public interface IEmployeeService {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    Employee login(String username, String password);

}
