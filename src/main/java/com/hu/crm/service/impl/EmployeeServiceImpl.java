package com.hu.crm.service.impl;

import com.hu.crm.domain.Employee;
import com.hu.crm.domain.Role;
import com.hu.crm.mapper.EmployeeMapper;
import com.hu.crm.page.PageResult;
import com.hu.crm.query.EmployeeQueryObject;
import com.hu.crm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Employee record) {
        int insert = employeeMapper.insert(record);
        List<Role> roles = record.getRoles();
        for (Role role : roles) {
            employeeMapper.insertRelation(record.getId(), role.getId());
        }
        return insert;
    }

    @Override
    public Employee selectByPrimaryKey(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> selectAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Employee record) {
        return employeeMapper.updateByPrimaryKey(record);
    }

    @Override
    public Employee login(String username, String password) {
        Employee current = employeeMapper.login(username, password);
        return current;
    }

    @Override
    public PageResult queryForPage(EmployeeQueryObject qo) {
        //查询结果数
        Long count = employeeMapper.queryForPageCount(qo);
        if (count == 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        //查询结果集
        List<Employee> employees = employeeMapper.queryForPage(qo);
        return new PageResult(count, employees);
    }

    @Override
    public void updateState(Long id) {
        employeeMapper.updateState(id);
    }

    @Override
    public List<Long> queryByEid(Long eid) {
        return employeeMapper.queryByEid();
    }
}
