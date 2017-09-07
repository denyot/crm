<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%@include file="common.jsp"%>
    <script type="text/javascript" src="../../js/views/index.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north'"
     style="height:100px;background: url('../../images/banner-pic.gif') no-repeat;background-size: cover;">
    <h1>心烽的系统</h1>
</div>
<div data-options="region:'south'"
     style="height:20px;background: url('../../images/banner-pic.gif') no-repeat;background-size: cover;">
    <center>版权归胡心烽本人所有,商业用途需授权</center>
    >
</div>
<div data-options="region:'west',title:'菜单栏',split:true" style="width:300px;">
    <div id="aa" class="easyui-accordion" data-options="fit:true">
        <div title="菜单" data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:10px;">
            <ul id="menu"></ul>
        </div>
        <div title="帮助" data-options="iconCls:'icon-help'" style="padding:10px;">
        </div>
        <div title="不知道取啥名好" data-options="iconCls:'icon-reload'">
        </div>
    </div>
</div>
<div data-options="region:'center'" style="padding:5px;background:#eee;">
    <div id="main_tabs">
        <div title="欢迎您" closable="true">
            <h3> hello world</h3>
        </div>
    </div>
</div>
</body>
</html>