package com.hu.crm.service;

import com.hu.crm.domain.Employee;
import com.hu.crm.page.PageResult;
import com.hu.crm.query.EmployeeQueryObject;

import java.util.List;
public interface IEmployeeService {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    Employee login(String username, String password);

    PageResult queryForPage(EmployeeQueryObject qo);

    void updateState(Long id);

    List<Long> queryByEid(Long eid);

}
