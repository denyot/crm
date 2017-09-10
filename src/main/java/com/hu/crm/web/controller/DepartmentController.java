package com.hu.crm.web.controller;

import com.hu.crm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/department_selectAll")
    @ResponseBody
    public List selectAll() {
        return departmentService.selectAll();
    }

    @RequestMapping("/department")
    public String department() {
        return "department";
    }
}
