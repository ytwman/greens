/**
 * Created by ytwman on 16/11/27.
 */

$(function () {
    // 注册全局事件
    $(document).bind('keydown', function (e) {
        // esc 关闭tab
        if (e.key === 'Escape') {
            closeCurrentTab();
        }

        // F2 收银台
        if (e.key === 'F2') {
            addTabPanel({id: 'menu-tools-cashier', title: '收银台', href: '/cashier.html'});
        }
    });

    // 收银台
    $('#menu-tools-cashier-btn').click(function () {
        addTabPanel({id: 'menu-tools-cashier', title: '收银台', href: '/cashier.html'});
    });

    // 关闭 tab panel
    $('#menu-tools-close-btn').click(function () {
        closeCurrentTab();
    })
})