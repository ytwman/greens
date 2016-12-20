/**
 * Created by ytwman on 16/12/4.
 */

$(function () {

    // 查询条件
    var goodsCategorySearchParams = {
        keywords: null
    };

    // 详情 dialog 模板
    var dialogOptions = {
        id: 'add-goods-category-dialog',
        title: '添加商品类目',
        iconCls: 'Disk',
        width: 400,
        height: 330,
        modal: true,
        cache: false,
        href: '/goods/category/add_goods_category.html'
    };

    // 商品类目
    $('#goods-category-list').datagrid({
        border: false, // 是否显示边框
        rownumbers: true, // 是否显示索引
        fit: true, // 填充父容器
        striped: true, // 是否开启行颜色间隔
        singleSelect: true, // 是否开启单行选择
        selectOnCheck: true, // 是否开启选择后选中行
        checkOnSelect: true, // 是否开启选中行选择
        pagination: true, // 是否开启分页组件
        fitColumns: true, // 自动设置表格宽度，方式横向滚动
        toolbar: '#goods-category-toolbar',
        url: projectPath + '/goods_category',
        queryParams: goodsCategorySearchParams,
        method: 'get'
    });

    // 查询条件初始化
    $('#goods-category-search-keywords').searchbox({
        searcher: function (newValue) {
            goodsCategorySearchParams.keywords = newValue;
            $('#goods-category-list').datagrid('load', goodsCategorySearchParams);
        }
    });

    // 添加商品类目
    $('#goods-category-add-btn').click(function () {
        $.dialog(dialogOptions);
    });

    // 修改供应商
    $('#goods-category-edit-btn').click(function () {
        // 是否选择
        var row = $('#goods-category-list').datagrid('getSelected');
        if (!row) {
            $.messager.alert('操作提示', '请选择一条记录在执行操作!', 'error');
            return;
        }

        $.dialog(dialogOptions, {id: row.id});
    });

    // 删除商品类目
    $('#goods-category-del-btn').click(function () {
        // 是否选择
        var row = $('#goods-category-list').datagrid('getSelected');
        if (!row) {
            $.messager.alert('操作提示', '请选择一条记录在执行操作!', 'error');
            return;
        }

        // 提示是否需要删除
        $.messager.confirm('删除商品类目', '您确定要删除商品类目, “' + row.name + '”', function (r) {
            if (r) {
                // 删除动作
                $.get(projectPath + '/goods_category/delete/' + row.id, function (result) {
                    if (!!result) {
                        $.messager.alert('删除商品类目失败', result.exMessage ? result.exMessage : '系统异常', 'error');
                        return;
                    }

                    $('#goods-category-list').datagrid('reload');
                }, 'json');
            }
        });
    });
});