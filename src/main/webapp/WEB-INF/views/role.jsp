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
    <title>角色管理</title>
    <%@include file="common.jsp" %>
    <script type="text/javascript" src="../../js/views/role.js"></script>
</head>
<body>
<table id="role_datagrid"></table>
<div id="role_datagrid_btn">
    <a class="easyui-linkbutton" iconCls='icon-add' plain="true" data-cmd="add">增加</a>
    <a id="role_datagrid_remove" class="easyui-linkbutton" iconCls='icon-remove' plain="true"
       data-cmd="remove">离职</a>
    <a id="role_datagrid_edit" class="easyui-linkbutton" iconCls='icon-edit' plain="true" data-cmd="edit">编辑</a>
    <a class="easyui-linkbutton" iconCls='icon-reload' plain="true" data-cmd="reload">刷新</a>
    <div>
        关键字<input name="keyword" placeholder="名称/编码"><a class="easyui-linkbutton" iconCls="icon-search"
                                                        data-cmd="searchBtn">搜索</a>
    </div>
</div>
<div id="role_dialog_btn">
    <a class="easyui-linkbutton" iconCls='icon-save' data-cmd="save">保存</a>
    <a class="easyui-linkbutton" iconCls='icon-cancel' data-cmd="cancel">取消</a>
</div>
<div id="role_dialog">
    <form id="role_form" action="" method="post">
        <table align="center" style="margin-top: 15px">
            <input type="hidden" name="id">
            <tr>
                <td>角色名称<input name="name"></td>
                <td>角色编码<input name="sn"></td>
            </tr>
            <tr>
                <td>
                    <table id="allPermission"></table>
                </td>
                <td>
                    <table id="selfPermission"></table>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
