$(function () {
    $('#employee_datagrid').datagrid({
        title: '员工管理',
        fit: true,
        url: 'employee.json',
        pagination: true,
        fitColumns: true,
        striped: true,
        rownumbers: true,
        singleSelect: true,
        toolbar: '#employee_datagrid_btn',
        columns: [
            [
                {field: 'username', title: '账号', width: 1, align: 'center'},
                {field: 'realName', title: '姓名', width: 1, align: 'center'},
                {field: 'tel', title: '电话', width: 1, align: 'center', formatter: deptFormatter},
                {field: 'email', title: '邮箱', width: 1, align: 'center'},
                {field: 'dept', title: '部门', width: 1, align: 'center'},
                {field: 'inputTime', title: '入职时间', width: 1, align: 'center'},
                {field: 'state', title: '状态', width: 1, align: 'center'},
                {field: 'admin', title: '是否超级管理员', width: 1, align: 'center'}
            ]
        ]
    });
    $("#employee_dialog").dialog({
        width: 250,
        height: 250,
        buttons: '#employee_dialog_btn',
        closed: true
    })
});

function deptFormatter(value, row, index) {
    if (row.dept) {
        return row.dept.name;
    }
    return value;
}

function add() {
    $("#employee_dialog").dialog("open");
    $("#employee_dialog").dialog("setTitle", "新增")
    $("#employee_form").form("clear");
}

function remove() {
    var data = $('#employee_datagrid').datagrid("getSelected");
    if (data) {
        $.messager.confirm("温馨提示", "确定要删除吗", function (r) {
            if (r) {
                $.get("delete.json?id=" + data.id, function (data) {
                    if (data.success) {
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            $('#employee_datagrid').datagrid("reload");
                        })
                    } else {
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            }
        });
    } else {
        $.messager.alert("温馨提示", "请选择要删除的数据", "info");
    }
}

function edit() {
    var data = $('#employee_datagrid').datagrid("getSelected");
    if (data) {
        $("#employee_dialog").dialog("open");
        $("#employee_dialog").dialog("setTitle", "编辑")
        $("#employee_form").form("clear");
        if (data.dept) {
            data["dept.id"] = data.dept.id;
        }
        $("#employee_form").form("load", data);
    } else {
        $.messager.alert("温馨提示", "请选择要编辑的数据", "info");
    }

}

function reload() {
    $('#employee_datagrid').datagrid("reload");
}

function save() {
    var id = $("[name=id]").val();
    var url;
    if (id) {
        url = "update.json"
    } else {
        url = "save.json"
    }
    $("#employee_form").form("submit", {
        url: url,
        success: function (data) {
            data = eval('(' + data + ')');
            if (data.success) {
                $.messager.alert("温馨提示", data.msg, 'info', function () {
                    $("#employee_dialog").dialog("close");
                    $('#employee_datagrid').datagrid("load");
                })
            }
        }
    });
}

function cancel() {
    $("#employee_dialog").dialog("close");
}
