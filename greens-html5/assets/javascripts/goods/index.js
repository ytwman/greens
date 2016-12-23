/**
 * Created by ytwman on 16/12/20.
 */


$(function () {

    // 查询条件
    var goodsSearchParams = {
        keywords: null,
        categoryId: null
    };

    // 详情 dialog 模板
    var dialogOptions = {
        id: 'add-goods-dialog',
        title: '添加商品',
        iconCls: 'Disk',
        width: 400,
        height: 420,
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

    // 查询条件初始化
    $('#goods-search-keywords').searchbox({
        onChange: function (newValue) {
            goodsSearchParams.keywords = newValue;
        },
        searcher: function (newValue) {
            goodsSearchParams.keywords = newValue;
            $('#goods-list').datagrid('load', goodsSearchParams);
        }
    });

    // 商品类目初始化数据
    $('#goods-search-category').combobox({
        url: projectPath + '/goods_category',
        method: 'get',
        valueField: 'id',
        textField: 'name',
        panelHeight: 120,
        // value: '-商品分类-',
        onChange: function (newValue) {
            goodsSearchParams.categoryId = newValue;
            $('#goods-list').datagrid('load', goodsSearchParams);
        }
    });

    // 查询按钮
    $('#goods-search-btn').click(function () {
        $('#goods-list').datagrid('load', goodsSearchParams);
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

        $.dialog(dialogOptions, {id: row.id, categoryId: row.categoryId});
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

    // 上下架商品
    $('#goods-lookup-btn').click(function () {
        // 是否选择
        var row = $('#goods-list').datagrid('getSelected');
        if (!row) {
            $.messager.alert('操作提示', '请选择一条记录在执行操作!', 'error');
            return;
        }

        var lookup = row.lookup == 0 ? "上架" : "下架";

        // 提示是否需要上下架
        $.messager.confirm('商品上下架', '您确定要<red style="color:red;">【' + lookup + '】商品, “' + row.name + '”</red>', function (r) {
            if (r) {
                // 删除动作
                $.get(projectPath + '/goods_info/lookup/' + row.id, function (result) {
                    if (!!result) {
                        $.messager.alert('商品上下架失败', result.exMessage ? result.exMessage : '系统异常', 'error');
                        return;
                    }

                    $('#goods-list').datagrid('reload');
                }, 'json');
            }
        });
    });
});

// 上下架状态格式化
function lookupFormatter(value, row) {
    console.log(value);
    console.log(row);
    return value == 1 ? '是' : '否';
}