package com.hu.crm.service.impl;

import com.hu.crm.domain.Employee;
import com.hu.crm.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)   //spring测试
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceImplTest {
    @Autowired
    private IEmployeeService employeeService;
    @Test
    public void insert() throws Exception {
        Employee employee = new Employee();
        employee.setEmail("222");
        employeeService.insert(employee);
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void selectAll() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}