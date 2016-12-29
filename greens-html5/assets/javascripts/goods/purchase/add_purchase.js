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
        onClickCell: onDblClickCell,
        onEndEdit: onEndEdit
    });

    // 采购日期控件初始化
    $('#add-purchaseDate').datebox().datebox('calendar').calendar({
        validator: function (date) {
            var now = new Date();
            var d1 = new Date(now.getFullYear(), now.getMonth(), now.getDate() - 10);
            var d2 = new Date(now.getFullYear(), now.getMonth(), now.getDate());
            return d1 <= date && date <= d2;
        }
    });

    // 采购日期控件改变事件
    $('#add-purchaseDate').datebox({
        onSelect: function (newValue) {
            purchaseSearchParams.purchaseDate = newValue.getTime();
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

    function endEditing() {
        if (editIndex == undefined) {
            return true
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
                $('#purchase-order-list').datagrid('selectRow', index)
                    .datagrid('beginEdit', index);
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

    function onEndEdit(index, row) {
        var ed = $(this).datagrid('getEditor', {
            index: index,
            field: 'productid'
        });
        row.productname = $(ed.target).combobox('getText');
    }

    function append() {
        if (endEditing()) {
            $('#purchase-order-list').datagrid('appendRow', {status: 'P'});
            editIndex = $('#purchase-order-list').datagrid('getRows').length - 1;
            $('#purchase-order-list').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
        }
    }

    // 添加行
    $('#add-purchase-item-btn').click(function () {
        append();
    })
});