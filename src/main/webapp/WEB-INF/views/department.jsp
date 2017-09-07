<%--
  Created by IntelliJ IDEA.
  User: XIAOMI
  Date: 2017/9/5
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>员工管理</title>
    <%@include file="common.jsp"%>
    <script type="text/javascript" src="../../js/views/employee.js"></script>
</head>
<body>
<table id="employee_datagrid"></table>
<div id="employee_datagrid_btn">
    <a class="easyui-linkbutton" iconCls='icon-add' plain="true" onclick="add()">增加</a>
    <a class="easyui-linkbutton" iconCls='icon-remove' plain="true" onclick="remove()">删除</a>
    <a class="easyui-linkbutton" iconCls='icon-edit' plain="true" onclick="edit()">编辑</a>
    <a class="easyui-linkbutton" iconCls='icon-reload' plain="true" onclick="reload()">刷新</a>
</div>
<div id="employee_dialog_btn">
    <a class="easyui-linkbutton" iconCls='icon-save' onclick="save()">保存</a>
    <a class="easyui-linkbutton" iconCls='icon-cancel' onclick="cancel()">取消</a>
</div>
<div id="employee_dialog">
    <form  id="employee_form" action="" method="post">
        <table align="center" style="margin-top: 15px;">
            <input type="hidden" name="id">
            <tr>
                <td>姓名</td>
                <td><input name="name"></td>
                <br>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input  name="age"></td>
                <br>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input  name="email"></td>
                <br>
            </tr>
            <tr>
                <td>部门</td>
                <td>
                    <select name="dept.id">
                        <option value="1">设计部</option>
                        <option value="2">总经办</option>
                        <option value="3">销售部</option>
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
