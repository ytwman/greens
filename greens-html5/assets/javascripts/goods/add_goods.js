/**
 * Created by ytwman on 16/12/21.
 */

$(function () {

    // 读取表单值
    var data = $.parameter('add-goods-dialog');
    if (!$.isEmptyObject(data)) {
        $('#add-goods-form').form('load', projectPath + '/goods_info/' + data.id);
    }

    // 表单提交动作
    $('#add-goods-form').form({
        url: projectPath + '/goods_info/save_or_update',
        onSubmit: function () {
            return $(this).form('enableValidation').form('validate');
        },
        success: function (result) {
            result = $.parseJSON(result);
            if (result) {
                $.messager.alert('错误提示', result.code ? result.exMessage : '系统异常', 'error');
            } else {
                $.messager.alert('操作提示', '保存商品类目成功!', 'info');
                $('#add-goods-dialog').dialog('close');
                $('#goods-list').datagrid('reload');
            }
        }
    });

    // 提交表单
    $('#add-goods-form-submit').click(function () {
        $('#add-goods-form').form('submit');
    });

    // 加载商品类目
    $('#add-goods-category').combobox({
        url: projectPath + '/goods_category',
        method: 'get',
        valueField: 'id',
        textField: 'name',
        panelHeight: 120,
        // value: '-商品分类-',
        onChange: function (newValue) {

        },
        onLoadSuccess: function () {
            var val = $(this).combobox('getData');
            for (var i in val) {
                if (!!data && val[i].id == data.goodsCategoryId) {
                    $(this).combobox('select', val[i].id);
                }
            }
        }
    });

});