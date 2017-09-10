$(function () {
    var empl_datagrid, empl_dialog, empl_form, keyword, datagrig_remove_edit;
    empl_datagrid = $('#employee_datagrid');
    empl_dialog = $("#employee_dialog");
    empl_form = $("#employee_form");
    keyword = $("[name=keyword]");
    datagrig_remove_edit = $("#employee_datagrid_remove,#employee_datagrid_edit");
    empl_datagrid.datagrid({
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
        onClickRow: function (rowIndex, rowData) {
            if (!rowData.state) {
                datagrig_remove_edit.linkbutton("disable")
            } else {
                datagrig_remove_edit.linkbutton("enable")
            }
        },
        columns: [
            [
                {field: 'username', title: '账号', width: 1, align: 'center'},
                {field: 'realname', title: '姓名', width: 1, align: 'center'},
                {field: 'tel', title: '电话', width: 1, align: 'center'},
                {field: 'email', title: '邮箱', width: 1, align: 'center'},
                {field: 'dept', title: '部门', width: 1, align: 'center', formatter: deptFormatter},
                {field: 'inputtime', title: '入职时间', width: 1, align: 'center'},
                {field: 'state', title: '状态', width: 1, align: 'center', formatter: stateFormatter},
                {field: 'admin', title: '是否超级管理员', width: 1, align: 'center',formatter: adminFormatter},
                {field: 'roles', title: '角色', width: 1, align: 'center'}
            ]
        ]
    });
    empl_dialog.dialog({
        width: 250,
        height: 400,
        buttons: '#employee_dialog_btn',
        closed: true
    });

    var cmdObj = {
        add: function () {
            empl_dialog.dialog("open");
            empl_dialog.dialog("setTitle", "新增")
            empl_form.form("clear");
        },

        remove: function () {
            var rowData = empl_datagrid.datagrid("getSelected");
            if (rowData) {
                $.messager.confirm("温馨提示", "确定该员工已离职吗", function (yes) {
                    if (yes) {
                        $.get("employee_delete?id=" + rowData.id, function (data) {
                            if (data.success) {
                                empl_datagrid.datagrid("reload");
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
        },

        edit: function () {
            var rowData = empl_datagrid.datagrid("getSelected");
            console.log(rowData);
            if (rowData) {
                empl_dialog.dialog("open");
                empl_dialog.dialog("setTitle", "编辑");
                empl_form.form("clear");
                //特殊属性处理,默认是同名匹配
                if (rowData.dept) {
                    rowData["dept.id"] = rowData.dept.id;
                }
                empl_form.form("load", rowData);
            } else {
                $.messager.alert("温馨提示", "请选择要编辑的数据", "info");
            }

        },

        reload: function () {
            empl_datagrid.datagrid("reload");
        },

        save: function () {
            var id = $("[name=id]").val();
            var url;
            if (id) {
                url = "/employee_update"
            } else {
                url = "/employee_save"
            }
            empl_form.form("submit", {
                url: url,
                onSubmit: function (param) {
                    var ids = $("#empl_roles").combobox("getValues");
                    for (var i = 0; i < ids.length; i++) {
                        var obj = ids[i];
                        param["roles[" + i + "].id"] = obj;
                    }
                },
                success: function (data) {
                    data = eval('(' + data + ')');
                    if (data.success) {
                        empl_dialog.dialog("close");
                        empl_datagrid.datagrid("load");
                        $.messager.alert("温馨提示", data.msg, 'info')
                    } else {
                        $.messager.alert("温馨提示", data.msg, 'info')
                    }
                }
            });
        },

        cancel: function () {
            empl_dialog.dialog("close");
        },
        searchBtn: function () {
            var value = keyword.val();
            $('#employee_datagrid').datagrid("load", {
                keyword: value
            });
        }


    };
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    //按键事件
    $(document).keyup(function (event) {
        console.log(event.keyCode);
        if (event.keyCode == 13) {//回车查询
            cmdObj.searchBtn();
        } else if (event.keyCode == 27) {//ESC 重置高级查询条件
            keyword.val("");
            cmdObj.searchBtn();
        }
    });
});

function deptFormatter(value, row, index) {
    if (value) {
        return value.name;
    }
    return value;
}
function adminFormatter(value, row, index) {
    if (value) {
        return "是";
    }
    return "否";
}

function rolesFormatter(value, row, index) {
    if (value) {
        return row;
    }
    return row;
}

function stateFormatter(value, row, index) {
    if (value) {
        return "<font color=\"green\">" + "正常" + "</font>";
    }
    return "<font color=\"red\">" + "离职" + "</font>";
}








