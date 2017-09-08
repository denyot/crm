package com.hu.crm.web.controller;

import com.hu.crm.domain.Permission;
import com.hu.crm.page.PageResult;
import com.hu.crm.query.PermissionQueryObject;
import com.hu.crm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;


    @RequestMapping("/permission_list")
    @ResponseBody
    public PageResult list(PermissionQueryObject qo) {
        PageResult result = permissionService.queryForPage(qo);
        return result;
    }

    @RequestMapping("/permission_save")
    @ResponseBody
    public Map<String, Object> save(Permission permission) {
        Map<String, Object> result = new HashMap<>();
        try {
            permissionService.insert(permission);
            result.put("success", true);
            result.put("msg", "保存成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", "保存异常请联系管理员");
        }
        return result;
    }
    @RequestMapping("/permission_update")
    @ResponseBody
    public Map<String, Object> update(Permission permission) {
        Map<String, Object> result = new HashMap<>();
        try {
            permissionService.updateByPrimaryKey(permission);
            result.put("success", true);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", "更新异常,请联系管理员");
        }
        return result;
    }
    @RequestMapping("/permission_delete")
    @ResponseBody
    public Map<String, Object> update(Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            permissionService.deleteByPrimaryKey(id);
            result.put("success", true);
            result.put("msg", "离职成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", "离职异常,请联系管理员");
        }
        return result;
    }
    @RequestMapping("/permission")
    public String permission() {
        return "permission";
    }
}
