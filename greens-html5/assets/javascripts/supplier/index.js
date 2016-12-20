/**
 * Created by ytwman on 16/12/13.
 */

$(function () {

    // 查询条件
    var supplierSearchParams = {
        keywords: null
    };

    // 详情 dialog 模板
    var dialogOptions = {
        id: 'add-supplier-dialog',
        title: '添加供应商',
        iconCls: 'Disk',
        width: 400,
        height: 450,
        modal: true,
        cache: false,
        href: '/supplier/add_supplier.html'
    };

    // 供应商
    $('#supplier-list').datagrid({
        border: false, // 是否显示边框
        rownumbers: true, // 是否显示索引
        fit: true, // 填充父容器
        striped: true, // 是否开启行颜色间隔
        singleSelect: true, // 是否开启单行选择
        selectOnCheck: true, // 是否开启选择后选中行
        checkOnSelect: true, // 是否开启选中行选择
        pagination: true, // 是否开启分页组件
        fitColumns: true, // 自动设置表格宽度，方式横向滚动
        toolbar: '#supplier-toolbar',
        url: projectPath + '/suppliers',
        queryParams: supplierSearchParams,
        method: 'get'
    });

    // 查询条件初始化
    $('#supplier-search-keywords').searchbox({
        searcher: function (newValue) {
            supplierSearchParams.keywords = newValue;
            $('#supplier-list').datagrid('load', supplierSearchParams);
        }
    });

    // 添加供应商
    $('#supplier-add-btn').click(function () {
        $.dialog(dialogOptions);
    });

    // 修改供应商
    $('#supplier-edit-btn').click(function () {
        // 是否选择
        var row = $('#supplier-list').datagrid('getSelected');
        if (!row) {
            $.messager.alert('操作提示', '请选择一条记录在执行操作!', 'error');
            return;
        }

        $.dialog(dialogOptions, {id: row.id});
    });

    // 删除供应商
    $('#supplier-del-btn').click(function () {
        // 是否选择
        var row = $('#supplier-list').datagrid('getSelected');
        if (!row) {
            $.messager.alert('操作提示', '请选择一条记录在执行操作!', 'error');
            return;
        }

        // 提示是否需要删除
        $.messager.confirm('删除供应商', '您确定要删除供应商, “' + row.name + '”', function (r) {
            if (r) {
                // 删除动作
                $.get(projectPath + '/suppliers/delete/' + row.id, function (result) {
                    if (!!result) {
                        $.messager.alert('删除供应商失败', result.exMessage ? result.exMessage : '系统异常', 'error');
                        return;
                    }

                    $('#supplier-list').datagrid('reload');
                }, 'json');
            }
        });
    });
});