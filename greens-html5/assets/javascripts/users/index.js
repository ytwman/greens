/**
 * Created by ytwman on 16/11/27.
 */

$(function () {

    // 查询条件
    var userSearchParams = {
        keywords: null,
        communityId: null
    };

    // 详情 dialog 模板
    var dialogOptions = {
        id: 'add-user-dialog',
        title: '添加用户',
        iconCls: 'Disk',
        width: 650,
        height: 420,
        modal: true,
        href: '/users/add_user.html'
    };

    // 角色表格显示
    $('#users-list').datagrid({
        border: false, // 是否显示边框
        rownumbers: true, // 是否显示索引
        fit: true, // 填充父容器
        striped: true, // 是否开启行颜色间隔
        singleSelect: true, // 是否开启单行选择
        selectOnCheck: true, // 是否开启选择后选中行
        checkOnSelect: true, // 是否开启选中行选择
        pagination: true, // 是否开启分页组件
        fitColumns: true, // 自动设置表格宽度，方式横向滚动
        toolbar: '#users-toolbar',
        url: projectPath + '/users',
        queryParams: userSearchParams,
        method: 'get',
        onDblClickRow: function (index, row) {
            addTabPanel({
                id: 'user-detail-panel',
                title: '用户详情',
                href: '/users/detail.html?userId=' + row.id,
                reload: true
            });
        }
    });

    // 查询条件初始化
    $('#user-search-keywords').textbox({
        onChange: function (newValue) {
            userSearchParams.keywords = newValue;
        }
    });

    // 社区初始化数据
    $('#user-search-community').combobox({
        url: projectPath + '/regions/1/communities',
        method: 'get',
        valueField: 'id',
        textField: 'name',
        panelHeight: 'auto',
        onChange: function (newValue) {
            userSearchParams.communityId = newValue;
        }
    });

    // 搜索
    $('#user-index-search-btn').click(function () {
        $('#users-list').datagrid('load', userSearchParams);
    });

    // 打开添加用户 dialog
    $('#user-index-add-btn').click(function () {
        $.dialog(dialogOptions);
    });

    // 打开修改用户 dialog
    $('#user-index-edit-btn').click(function () {
        var row = $('#users-list').datagrid('getSelected');
        if (!row) {
            $.messager.alert('操作提示', '请选择一条记录在执行操作!', 'error');
            return;
        }

        $.dialog(dialogOptions, {id: row.id});
    });

    // 删除用户按钮
    $('#user-index-del-btn').click(function () {
        // 是否选择
        var row = $('#users-list').datagrid('getSelected');
        if (!row) {
            $.messager.alert('操作提示', '请选择一条记录在执行操作!', 'error');
            return;
        }

        // 提示是否需要删除
        $.messager.confirm('删除用户', '您确定要删除用户, “' + row.name + '”', function (r) {
            if (r) {
                // 删除动作
                $.get(projectPath + '/users/delete/' + row.id, function (result) {
                    if (!!result) {
                        $.messager.alert('删除用户失败', result.exMessage, 'error');
                        return;
                    }

                    $('#users-list').datagrid('reload');
                }, 'json');
            }
        });
    });

});
