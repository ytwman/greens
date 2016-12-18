/**
 * Created by ytwman on 16/12/4.
 */

$(function () {

    // 读取表单值
    var data = $.parameter('add-goods-category-dialog');
    if (!$.isEmptyObject(data)) {
        $('#add-goods-category-form').form('load', projectPath + '/goods_category/' + data.id);
    }

    // 表单提交动作
    $('#add-goods-category-form').form({
        url: projectPath + '/goods_category/save_or_update',
        onSubmit: function () {
            return $(this).form('enableValidation').form('validate');
        },
        success: function (result) {
            result = $.parseJSON(result);
            if (result) {
                $.messager.alert('错误提示', result.code ? result.exMessage : '系统异常', 'error');
            } else {
                $.messager.alert('操作提示', '保存商品类目成功!', 'info');
                $('#add-goods-category-dialog').dialog('close');
                $('#goods-category-list').datagrid('reload');
            }
        }
    });

    // 提交表单
    $('#add-goods-category-form-submit').click(function () {
        $('#add-goods-category-form').form('submit');
    });

});