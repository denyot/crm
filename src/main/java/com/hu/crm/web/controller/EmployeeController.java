package com.hu.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
    @RequestMapping("/employee")
    public String index() {
        System.out.println("EmployeeCroller.index");
        return "employee";
    }
}
