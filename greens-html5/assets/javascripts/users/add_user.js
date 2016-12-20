/**
 * Created by ytwman on 16/11/27.
 */

$(function () {

    // 读取表单值
    var data = $.parameter('add-user-dialog');
    if (!$.isEmptyObject(data)) {
        $('#add-goods-category-form').form('load', projectPath + '/goods_category/' + data.id);
    }

    // 设置省份数据
    $('#province').combobox({
        url: projectPath + '/regions/provinces',
        method: 'get',
        valueField: 'id',
        textField: 'name',
        panelHeight: 160,
        onChange: function (newValue) {
            $('#city').combobox('clear');
            $('#city').combobox('reload', projectPath + '/regions/' + newValue + '/childrens');
        }
    });


    // 表单提交动作
    $('#add-user-form').form({
        url: '/users/save_or_update',
        onSubmit: function () {
            return $(this).form('enableValidation').form('validate');
        },
        success: function (result) {
            if (!!result) {
                $('#add-user-dialog').dialog('close');
                $.messager.alert('操作提示', '保存用户成功!', 'info');
            } else {
                $.messager.alert('', result, 'error');
            }
        }
    });

    // 提交表单
    $('#add-user-form-submit').click(function () {
        $('#add-user-form').form('submit');
    });
});