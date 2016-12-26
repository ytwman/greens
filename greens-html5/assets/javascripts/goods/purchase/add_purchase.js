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
        url: projectPath + '/purchase',
        method: 'get',
        // 双击编辑行记录
        onClickCell: onDblClickCell,
        onEndEdit: onEndEdit
    });

    // 编辑行索引
    var editIndex = undefined;

    function endEditing() {
        if (editIndex == undefined) {
            return true
        }
        if ($('#dg').datagrid('validateRow', editIndex)) {
            $('#dg').datagrid('endEdit', editIndex);
            editIndex = undefined;
            return true;
        } else {
            return false;
        }
    }

    function onDblClickCell(index, field) {
        if (editIndex != index) {
            if (endEditing()) {
                $('#dg').datagrid('selectRow', index)
                    .datagrid('beginEdit', index);
                var ed = $('#dg').datagrid('getEditor', {index: index, field: field});
                if (ed) {
                    ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
                }
                editIndex = index;
            } else {
                setTimeout(function () {
                    $('#dg').datagrid('selectRow', editIndex);
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
});