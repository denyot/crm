$(function () {
    $('#employee_datagrid').datagrid({
        title: '员工管理',
        fit: true,
        url: '/employee_list',
        pagination: true,
        fitColumns: true,
        striped: true,
        rownumbers: true,
        singleSelect: true,
        toolbar: '#employee_datagrid_btn',
        pageList: [20, 30, 40, 50, 80, 100],
        pageSize: 40,

        columns: [
            [
                {field: 'username', title: '账号', width: 1, align: 'center'},
                {field: 'realname', title: '姓名', width: 1, align: 'center'},
                {field: 'tel', title: '电话', width: 1, align: 'center'},
                {field: 'email', title: '邮箱', width: 1, align: 'center'},
                {field: 'dept', title: '部门', width: 1, align: 'center', formatter: deptFormatter},
                {field: 'inputtime', title: '入职时间', width: 1, align: 'center'},
                {field: 'state', title: '状态', width: 1, align: 'center', formatter: stateFormatter},
                {field: 'admin', title: '是否超级管理员', width: 1, align: 'center'}
            ]
        ],
        onClickRow:function (rowIndex,rowData) {
                if(!rowData.state){
                    $("#employee_datagrid_remove,#employee_datagrid_edit").linkbutton("disable")
                }else {
                    $("#employee_datagrid_remove,#employee_datagrid_edit").linkbutton("enable")
                }
        }
    });
    $("#employee_dialog").dialog({
        width: 250,
        height: 320,
        buttons: '#employee_dialog_btn',
        closed: true
    })
});

function deptFormatter(value, row, index) {
    if (value) {
        return value.name;
    }
    return value;
}

function stateFormatter(value, row, index) {
    if (value) {
        return "<font color=\"green\">" + "正常" + " </font>";
    }
    return "<font color=\"red\">" + "离职" + " </font>";
}

function add() {
    $("#employee_dialog").dialog("open");
    $("#employee_dialog").dialog("setTitle", "新增")
    $("#employee_form").form("clear");
}

function remove() {
    var rowData = $('#employee_datagrid').datagrid("getSelected");
    if (rowData) {
        $.messager.confirm("温馨提示", "确定该员工已离职吗", function (yes) {
            if (yes) {
                $.get("employee_delete?id=" + rowData.id, function (data) {
                    if (data.success) {
                        $('#employee_datagrid').datagrid("reload");
                        $.messager.alert("温馨提示", data.msg, "info");
                    } else {
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            }
        });
    } else {
        $.messager.alert("温馨提示", "请选择要离职的员工", "info");
    }
}

function edit() {
    var rowData = $('#employee_datagrid').datagrid("getSelected");
    console.log(rowData)
    if (rowData) {
        $("#employee_dialog").dialog("open");
        $("#employee_dialog").dialog("setTitle", "编辑")
        $("#employee_form").form("clear");
        //特殊属性处理,默认是同名匹配
        if (rowData.dept) {
            rowData["dept.id"] = rowData.dept.id;
        }
        $("#employee_form").form("load", rowData);
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
        url = "/employee_update"
    } else {
        url = "/employee_save"
    }
    $("#employee_form").form("submit", {
        url: url,
        success: function (data) {
            data = eval('(' + data + ')');
            if (data.success) {
                $("#employee_dialog").dialog("close");
                $('#employee_datagrid').datagrid("load");
                $.messager.alert("温馨提示", data.msg, 'info')
            } else {
                $.messager.alert("温馨提示", data.msg, 'info')
            }
        }
    });
}

function cancel() {
    $("#employee_dialog").dialog("close");
}
