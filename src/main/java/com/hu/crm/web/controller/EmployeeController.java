package com.hu.crm.web.controller;

import com.hu.crm.domain.Employee;
import com.hu.crm.service.IEmployeeService;
import com.hu.crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(String username, String password, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        Employee currentUser = employeeService.login(username, password);
        if (currentUser == null) {
            result.put("success", false);
            result.put("msg", "账号或密码有误");
        } else {
            result.put("success", true);
            result.put("msg", "登陆成功");
            session.setAttribute(UserContext.USERINSESSION, currentUser);
        }
        return result;
    }

    @RequestMapping("/employee")
    public String list() {
        System.out.println("EmployeeCroller.index");
        return "employee";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/department")
    public String department() {
        return "department";
    }
}
