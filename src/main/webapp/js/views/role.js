$(function () {
    var datagrid, dialog, form, keyword,allPermission, selfPermission;
    datagrid = $('#role_datagrid');
    dialog = $("#role_dialog");
    form = $("#role_form");
    keyword = $("[name=keyword]");
    allPermission = $("#allPermission");
    selfPermission = $("#selfPermission");
    datagrid.datagrid({
        title: '角色管理',
        fit: true,
        url: '/role_list',
        pagination: true,
        fitColumns: true,
        striped: true,
        rownumbers: true,
        singleSelect: true,
        toolbar: '#role_datagrid_btn',
        pageList: [20, 30, 40, 50, 80, 100],
        pageSize: 40,
        columns: [
            [
                {field: 'name', title: '角色名称', width: 1, align: 'center'},
                {field: 'sn', title: '角色编码', width: 1, align: 'center'}
            ]
        ]
    });

    allPermission.datagrid({
        width: 300,
        height: 300,
        url: '/permission_list',
        pagination: true,
        title: '所有权限',
        fitColumns: true,
        striped: true,
        rownumbers: true,
        singleSelect: true,
        onDblClickRow: function (rowIndex, rowData) {
            // 遍历selfPermission所有行,id不同则添加,相同则选中
            var rows = selfPermission.datagrid("getRows");
            var flag = true;
            var index = -1;
            for (var i = 0; i < rows.length; i++) {
                if (rowData.id == rows[i].id) {
                    flag = false;
                    index = i;
                }
            }
            if (flag) {
                selfPermission.datagrid("appendRow", rowData);
            } else {
                selfPermission.datagrid("selectRow", index);
            }
        },
        columns: [
            [
                {field: 'name', title: '权限名称', width: 1, align: 'center'}
            ]
        ]
    });
    var pager = allPermission.datagrid("getPager");
    pager.pagination({
        showPageList: false,
        showRefresh: false,
        displayMsg: ''
    });
    selfPermission.datagrid({
        width: 300,
        height: 300,
        title: '已有权限',
        fitColumns: true,
        striped: true,
        pagination: true,
        rownumbers: true,
        singleSelect: true,
        onDblClickRow: function (rowIndex, rowData) {
            selfPermission.datagrid("deleteRow", rowIndex);
        },
        columns: [
            [
                {field: 'name', title: '权限名称', width: 1, align: 'center'}
            ]
        ]
    });
    var pager = selfPermission.datagrid("getPager");
    pager.pagination({
        showPageList: false,
        showRefresh: false,
        displayMsg: ''
    });
    dialog.dialog({
        width: 700,
        height: 430,
        buttons: '#role_dialog_btn',
        closed: true
    });

    var cmdObj = {
        add: function () {
            dialog.dialog("open");
            dialog.dialog("setTitle", "新增")
            $("input[name=name],[name=sn]").val("");
            selfPermission.datagrid("loadData");
        },

        remove: function () {
            var rowData = datagrid.datagrid("getSelected");
            if (rowData) {
                $.messager.confirm("温馨提示", "确定该角色已离职吗", function (yes) {
                    if (yes) {
                        $.get("role_delete?id=" + rowData.id, function (data) {
                            if (data.success) {
                                datagrid.datagrid("reload");
                                $.messager.alert("温馨提示", data.msg, "info");
                            } else {
                                $.messager.alert("温馨提示", data.msg, "info");
                            }
                        });
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择要离职的角色", "info");
            }
        },

        edit: function () {
            var rowData = datagrid.datagrid("getSelected");
            if (rowData) {
                dialog.dialog("open");
                dialog.dialog("setTitle", "编辑")
                $("input[name=name],[name=sn]").val("");
                //特殊属性处理,默认是同名匹配
                if (rowData.dept) {
                    rowData["dept.id"] = rowData.dept.id;
                }
                var options = selfPermission.datagrid("options");
                options.url="/permission_selectByRoleId";
                selfPermission.datagrid("load",{
                    rid:rowData.id
                });
                form.form("load", rowData);
            } else {
                $.messager.alert("温馨提示", "请选择要编辑的数据", "info");
            }

        },

        reload: function () {
            datagrid.datagrid("reload");
        },

        save: function () {
            var id = $("[name=id]").val();
            var url;
            if (id) {
                url = "/role_update"
            } else {
                url = "/role_save"
            }
            form.form("submit", {
                url: url,
                onSubmit: function (params) {
                    var rows = selfPermission.datagrid("getRows");
                    for (var i = 0; i < rows.length; i++) {
                        params["permissions[" + i + "].id"] = rows[i].id;

                    }
                },
                success: function (data) {
                    data = eval('(' + data + ')');
                    if (data.success) {
                        dialog.dialog("close");
                        datagrid.datagrid("load");
                        $.messager.alert("温馨提示", data.msg, 'info')
                    } else {
                        $.messager.alert("温馨提示", data.msg, 'info')
                    }
                }
            });
        },

        cancel: function () {
            dialog.dialog("close");
        },
        searchBtn: function () {
            var value = keyword.val();
            $('#role_datagrid').datagrid("load", {
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
        if (event.keyCode == 13) {//回车查询
            cmdObj.searchBtn();
        } else if (event.keyCode == 27) {//ESC 重置高级查询条件
            keyword.val("");
            cmdObj.searchBtn();
        }
    });
});









