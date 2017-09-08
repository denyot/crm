package com.hu.crm.web.controller;

import com.hu.crm.domain.Role;
import com.hu.crm.page.PageResult;
import com.hu.crm.query.RoleQueryObject;
import com.hu.crm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RoleController {
    @Autowired
    private IRoleService roleService;


    @RequestMapping("/role_list")
    @ResponseBody
    public PageResult list(RoleQueryObject qo) {
        PageResult result = roleService.queryForPage(qo);
        return result;
    }

    @RequestMapping("/role_save")
    @ResponseBody
    public Map<String, Object> save(Role role) {
        Map<String, Object> result = new HashMap<>();
        try {
            roleService.insert(role);
            result.put("success", true);
            result.put("msg", "保存成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", "保存异常请联系管理员");
        }
        return result;
    }
    @RequestMapping("/role_update")
    @ResponseBody
    public Map<String, Object> update(Role role) {
        Map<String, Object> result = new HashMap<>();
        try {
            roleService.updateByPrimaryKey(role);
            result.put("success", true);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", "更新异常,请联系管理员");
        }
        return result;
    }
    @RequestMapping("/role_delete")
    @ResponseBody
    public Map<String, Object> update(Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            roleService.updateState(id);
            result.put("success", true);
            result.put("msg", "离职成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", "离职异常,请联系管理员");
        }
        return result;
    }
    @RequestMapping("/role")
    public String role() {
        return "role";
    }
}
