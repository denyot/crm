package com.hu.crm.web.controller;

import com.hu.crm.domain.Employee;
import com.hu.crm.page.PageResult;
import com.hu.crm.query.EmployeeQueryObject;
import com.hu.crm.service.IEmployeeService;
import com.hu.crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    /**
     *
     * @param username
     * @param password
     * @param request
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(String username, String password, HttpServletRequest request) {
        UserContext.set(request);
        Map<String, Object> result = new HashMap<>();
        Employee currentUser = employeeService.login(username, password);
        if (currentUser == null) {
            result.put("success", false);
            result.put("msg", "账号或密码有误");
        } else {
            result.put("success", true);
            result.put("msg", "登陆成功");
            request.getSession().setAttribute(UserContext.USERINSESSION, currentUser);
        }
        return result;
    }

    @RequestMapping("/employee_list")
    @ResponseBody
    public PageResult list(EmployeeQueryObject qo) {
        PageResult result = employeeService.queryForPage(qo);
        return result;
    }

    @RequestMapping("/employee_save")
    @ResponseBody
    public Map<String, Object> save(Employee employee) {
        Map<String, Object> result = new HashMap<>();
        try {
            employee.setAdmin(false);
            employee.setPassword("1");
            employee.setState(true);
            employeeService.insert(employee);
            result.put("success", true);
            result.put("msg", "保存成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", "保存异常请联系管理员");
        }
        return result;
    }
    @RequestMapping("/employee_update")
    @ResponseBody
    public Map<String, Object> update(Employee employee) {
        Map<String, Object> result = new HashMap<>();
        try {
            employeeService.updateByPrimaryKey(employee);
            result.put("success", true);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", "更新异常,请联系管理员");
        }
        return result;
    }
    @RequestMapping("/employee_delete")
    @ResponseBody
    public Map<String, Object> update(Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            employeeService.updateState(id);
            result.put("success", true);
            result.put("msg", "离职成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", "离职异常,请联系管理员");
        }
        return result;
    }


    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/department")
    public String department() {
        return "department";
    }

    @RequestMapping("/employee")
    public String employee() {
        return "employee";
    }
}
