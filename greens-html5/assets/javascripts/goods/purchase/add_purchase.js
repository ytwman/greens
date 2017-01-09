/**
 * Created by ytwman on 16/12/15.
 */

$(function () {

    $('#purchase-order-list').datagrid({
        border: false, // 是否显示边框
        rownumbers: true, // 是否显示索引
        // fit: true, // 填充父容器
        height: '345',
        striped: true, // 是否开启行颜色间隔
        singleSelect: true, // 是否开启单行选择
        selectOnCheck: true, // 是否开启选择后选中行
        checkOnSelect: true, // 是否开启选中行选择
        // pagination: true, // 是否开启分页组件
        fitColumns: true, // 自动设置表格宽度，方式横向滚动
        toolbar: '#purchase-order-toolbar',
        url: projectPath + '/purchase_order',
        method: 'get',
        // 双击编辑行记录
        onDblClickCell: onDblClickCell,
        onEndEdit: onEndEdit
    });

    // 采购日期控件初始化
    $('#add-purchaseDate').datebox().datebox('calendar').calendar({
        validator: function (date) {
            var now = new Date();
            var d1 = new Date(now.getFullYear(), now.getMonth(), now.getDate() - 3);
            var d2 = new Date(now.getFullYear(), now.getMonth(), now.getDate() + 3);
            return d1 <= date && date <= d2;
        }
    });

    // 加载采购人清单
    $('#add-purchaser').combobox({
        url: projectPath + '/purchase_order/person',
        method: 'get',
        valueField: 'id',
        textField: 'name',
        panelHeight: 120
    });

    // 编辑行索引
    //====================================================
    var editIndex = undefined;

    // 获取 datagrid 当前的编辑状态
    function endEditing() {
        if (editIndex == undefined) {
            return true;
        }
        if ($('#purchase-order-list').datagrid('validateRow', editIndex)) {
            $('#purchase-order-list').datagrid('endEdit', editIndex);
            editIndex = undefined;
            return true;
        } else {
            return false;
        }
    }

    function onDblClickCell(index, field) {
        if (editIndex != index) {
            if (endEditing()) {
                $('#purchase-order-list').datagrid('selectRow', index).datagrid('beginEdit', index);
                var ed = $('#purchase-order-list').datagrid('getEditor', {index: index, field: field});
                if (ed) {
                    ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
                }
                editIndex = index;
            } else {
                setTimeout(function () {
                    $('#purchase-order-list').datagrid('selectRow', editIndex);
                }, 0);
            }
        }
    }

    // 结束编辑状态
    function onEndEdit(index, row) {
        // 如果是第一次编辑允许添加下一行，如果是重新编辑按回车之后不允许添加下一行
        // 商品编码回车默认是1，商品编码和数量都可以按回车添加下一个编辑行


        // 获取指定的编辑行
        // 供应商

        // 商品
        var goods = $(this).datagrid('getEditor', {
            index: index,
            field: 'goodsCode'
        });

        // 获取编辑项目
        var g = $(goods.target).combogrid('grid');
        var r = g.datagrid('getSelected');


        console.log(r);
        if (!r) {
            return;
        }

        // 数量
        var amount = $(this).datagrid('getEditor', {
            index: index,
            field: 'amount'
        });
        var a = $(amount.target).numberbox('getText');

        // 设置行记录数据
        row.goodsCode = r.code;
        row.goodsName = r.name;
        row.price = 10.20;
        row.amount = a;
        row.total = row.price * row.amount;
    }

    // 点击添加按钮或者回车添加行记录
    function append() {
        if (endEditing()) {
            // 添加一行
            $('#purchase-order-list').datagrid('appendRow', {amount: 1});

            // 选择最后一行进行编辑
            editIndex = $('#purchase-order-list').datagrid('getRows').length - 1;
            $('#purchase-order-list').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
        }
    }

    // 添加行
    $('#add-purchase-item-btn').click(function () {
        append();
    });

    // 删除行
    $('#del-purchase-item-btn').click(function () {
        if (editIndex == undefined) {
            return;
        }
        $('#purchase-order-list').datagrid('cancelEdit', editIndex).datagrid('deleteRow', editIndex);
        editIndex = undefined;
    });

    // 提交记录
    $('#mod-purchase-item-btn').click(function () {

    });
});

// 自动加载商品编码
function goodsLoader(param, success, error) {
    var q = param.q || '';
    if (q.length <= 1) {
        return false;
    }

    $.ajax({
        url: projectPath + '/goods_info',
        dataType: 'json',
        data: {
            keywords: q
        },
        success: success,
        error: function () {
            error.apply(this, arguments);
        }
    });
}

// 格式化
function formatter() {

}