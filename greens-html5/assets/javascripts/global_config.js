/**
 * Created by ytwman on 16/11/27.
 */

// 项目路径
var projectPath = '/manager-web';

// 页面请求 Dialog 传值作用域
var _data = new Object();

$(function () {

    // 页面布局框架高度
    $(window).resize(function () {
        var mainContent = $('#main-content');
        mainContent.layout('resize', {
            height: ($(window).height() - 5),
            width: ($(window).width())
        });
    }).resize();

    $.extend({
        dialog: function (options, data) {
            // 注册参数
            window._data[options.id] = data;

            // 创建新的
            var dialog = $('#' + options.id);
            if (dialog.length == 0) {
                dialog = $('<div/>');
                dialog.dialog(options);
            } else {
                dialog.dialog('open');
                // dialog.dialog('refresh', options.href);
            }
        },
        // dialog id 做为作用域,传值使用
        parameter: function (id) {
            return $.map(window._data, function (val, key) {
                return key == id ? val : null;
            })[0];
        },
        formatter: function (date) {
            console.log($.fn.datebox.defaults.formatter(date) + " 0:00:00");
            return $.fn.datebox.defaults.formatter(date) + " 00:00:01";
        }
    })

});