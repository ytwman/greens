/**
 * Created by ytwman on 16/12/20.
 */


$(function () {

    // 查询条件
    var goodsSearchParams = {
        keywords: null
    };

    // 详情 dialog 模板
    var dialogOptions = {
        id: 'add-goods-dialog',
        title: '添加商品',
        iconCls: 'Disk',
        width: 400,
        height: 450,
        modal: true,
        cache: false,
        href: '/goods/add_goods.html'
    };

    // 商品
    $('#goods-list').datagrid({
        border: false, // 是否显示边框
        rownumbers: true, // 是否显示索引
        fit: true, // 填充父容器
        striped: true, // 是否开启行颜色间隔
        singleSelect: true, // 是否开启单行选择
        selectOnCheck: true, // 是否开启选择后选中行
        checkOnSelect: true, // 是否开启选中行选择
        pagination: true, // 是否开启分页组件
        fitColumns: true, // 自动设置表格宽度，方式横向滚动
        toolbar: '#goods-toolbar',
        url: projectPath + '/goods_info',
        queryParams: goodsSearchParams,
        method: 'get'
    });

    // 添加商品
    $('#goods-add-btn').click(function () {
        $.dialog(dialogOptions);
    });

    // 修改商品
    $('#goods-edit-btn').click(function () {
        // 是否选择
        var row = $('#goods-list').datagrid('getSelected');
        if (!row) {
            $.messager.alert('操作提示', '请选择一条记录在执行操作!', 'error');
            return;
        }

        $.dialog(dialogOptions, {id: row.id});
    });

    // 删除商品
    $('#goods-del-btn').click(function () {
        // 是否选择
        var row = $('#goods-list').datagrid('getSelected');
        if (!row) {
            $.messager.alert('操作提示', '请选择一条记录在执行操作!', 'error');
            return;
        }

        // 提示是否需要删除
        $.messager.confirm('删除商品', '您确定要删除商品, “' + row.name + '”', function (r) {
            if (r) {
                // 删除动作
                $.get(projectPath + '/goods_info/delete/' + row.id, function (result) {
                    if (!!result) {
                        $.messager.alert('删除商品失败', result.exMessage ? result.exMessage : '系统异常', 'error');
                        return;
                    }

                    $('#goods-list').datagrid('reload');
                }, 'json');
            }
        });
    });
});

// 查询方法
function doGoodsSearch(value) {
    $('#goods-list').datagrid('load', {keywords: value});
}