/**
 * Created by ytwman on 16/12/14.
 */

$(function () {

    // 读取表单值
    var data = $.parameter('add-supplier-dialog');
    if (!$.isEmptyObject(data)) {
        $('#add-supplier-form').form('load', projectPath + '/suppliers/' + data.id);
    }

    // 表单提交动作
    $('#add-supplier-form').form({
        url: projectPath + '/suppliers/save_or_update',
        onSubmit: function () {
            return $(this).form('enableValidation').form('validate');
        },
        success: function (result) {
            result = $.parseJSON(result);
            if (result) {
                $.messager.alert('错误提示', result.code ? result.exMessage : '系统异常', 'error');
            } else {
                $.messager.alert('操作提示', '保存供应商成功!', 'info');
                $('#add-supplier-dialog').dialog('close');
                $('#supplier-list').datagrid('reload');
            }
        }
    });

    // 提交表单
    $('#add-supplier-form-submit').click(function () {
        $('#add-supplier-form').form('submit');
    });
});