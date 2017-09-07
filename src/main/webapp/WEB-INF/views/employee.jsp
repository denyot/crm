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
    <%@include file="common.jsp" %>
    <script type="text/javascript" src="../../js/views/employee.js"></script>
</head>
<body>
<table id="employee_datagrid"></table>
<div id="employee_datagrid_btn">
    <a class="easyui-linkbutton" iconCls='icon-add' plain="true" onclick="add()">增加</a>
    <a id="employee_datagrid_remove" class="easyui-linkbutton" iconCls='icon-remove' plain="true"
       onclick="remove()">离职</a>
    <a id="employee_datagrid_edit" class="easyui-linkbutton" iconCls='icon-edit' plain="true" onclick="edit()">编辑</a>
    <a class="easyui-linkbutton" iconCls='icon-reload' plain="true" onclick="reload()">刷新</a>
    <div>
        关键字<input name="keyword" placeholder="账号/姓名/邮箱/电话/"><a class="easyui-linkbutton" iconCls="icon-search" onclick="searchBtn()">搜索</a>
    </div>
</div>
<div id="employee_dialog_btn">
    <a class="easyui-linkbutton" iconCls='icon-save' onclick="save()">保存</a>
    <a class="easyui-linkbutton" iconCls='icon-cancel' onclick="cancel()">取消</a>
</div>
<div id="employee_dialog">
    <form id="employee_form" action="" method="post">
        <table>
            <input type="hidden" name="id">
            <tr>
                <td>账户</td>
                <td><input name="username"></td>
                <br>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input name="realname"></td>
                <br>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input name="email"></td>
                <br>
            </tr>
            <tr>
                <td>电话</td>
                <td><input name="tel"></td>
                <br>
            </tr>
            <tr>
                <td>入职时间</td>
                <td><input name="inputtime" class="easyui-datebox"></td>
                <br>
            </tr>
            <tr>
                <td>部门</td>
                <td>
                    <input class="easyui-combobox" name="dept.id"
                           data-options="
					url:'/department_selectAll',
					method:'get',
					valueField:'id',
					textField:'name',
					panelHeight:'auto'
			">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
