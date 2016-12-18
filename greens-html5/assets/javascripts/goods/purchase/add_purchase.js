/**
 * Created by ytwman on 16/12/15.
 */

$(function () {

    $('#purchase-order-list').datagrid({
        border: false, // 是否显示边框
        rownumbers: true, // 是否显示索引
        fit: true, // 填充父容器
        striped: true, // 是否开启行颜色间隔
        singleSelect: true, // 是否开启单行选择
        selectOnCheck: true, // 是否开启选择后选中行
        checkOnSelect: true, // 是否开启选中行选择
        // pagination: true, // 是否开启分页组件
        fitColumns: true, // 自动设置表格宽度，方式横向滚动
        toolbar: '#purchase-order-toolbar',
        url: projectPath + '/purchase',
        method: 'get'
    });
});