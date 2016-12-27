/**
 * Created by ytwman on 16/12/15.
 */

$(function () {
    var purchaseSearchParams = {
        keywords: null,
        purchaseDate: null,
        purchaserId: null,
        audit: null,
    };

    // 商品采购单
    $('#purchase-list').datagrid({
        border: false, // 是否显示边框
        rownumbers: true, // 是否显示索引
        fit: true, // 填充父容器
        striped: true, // 是否开启行颜色间隔
        singleSelect: true, // 是否开启单行选择
        selectOnCheck: true, // 是否开启选择后选中行
        checkOnSelect: true, // 是否开启选中行选择
        pagination: true, // 是否开启分页组件
        fitColumns: true, // 自动设置表格宽度，方式横向滚动
        toolbar: '#purchase-toolbar',
        url: projectPath + '/purchase_order',
        queryParams: purchaseSearchParams,
        method: 'get'
    });

    // 查询条件初始化
    $('#purchase-search-keywords').searchbox({
        searcher: function (newValue) {
            purchaseSearchParams.keywords = newValue;
            $('#purchase-list').datagrid('load', purchaseSearchParams);
        }
    });

    // 采购日期控件初始化
    $('#purchase-search-purchase-date').datebox().datebox('calendar').calendar({
        validator: function (date) {
            var now = new Date();
            var d1 = new Date(now.getFullYear(), now.getMonth(), now.getDate() - 10);
            var d2 = new Date(now.getFullYear(), now.getMonth(), now.getDate());
            return d1 <= date && date <= d2;
        },
        onSelect: function (newValue) {
            purchaseSearchParams.purchaseDate = $.formatter(newValue);
            $('#purchase-list').datagrid('load', purchaseSearchParams);
        },
    });

    // 查询按钮
    $('#purchase-search-btn').click(function () {
        $('#purchase-list').datagrid('load', purchaseSearchParams);
    });

    // 添加采购单
    $('#purchase-add-btn').click(function () {
        $.dialog({
            id: 'add-purchase-dialog',
            title: '添加商品采购单',
            iconCls: 'Disk',
            width: 720,
            height: 640,
            modal: true,
            cache: false,
            href: '/goods/purchase/add_purchase.html'
        });
    });

    // 删除采购单
    $('#purchase-del-btn').click(function () {
        // 是否选择
        var row = $('#purchase-list').datagrid('getSelected');
        if (!row) {
            $.messager.alert('操作提示', '请选择一条记录在执行操作!', 'error');
            return;
        }

        // 提示是否需要删除
        $.messager.confirm('删除采购单', '您确定要删除采购单, “' + row.name + '”', function (r) {
            if (r) {
                // 删除动作
                $.get(projectPath + '/purchase_order/delete/' + row.id, function (result) {
                    if (!!result) {
                        $.messager.alert('删除采购单失败', result.exMessage ? result.exMessage : '系统异常', 'error');
                        return;
                    }

                    $('#purchase-list').datagrid('reload');
                }, 'json');
            }
        });
    });

    // 打印采购单
    $('#purchase-print-btn').click(function() {
        $('body').printPreview();
    })
});

// 采购日期格式化
function purchaseDateFormatter(value) {
    return $.fn.datebox.defaults.formatter(value);
}