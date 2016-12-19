var navbar = [{
    title: '订单管理',
    iconCls: 'Pagewhitepastetable',
    subMenu: [
        {id: 'menu-order-list', title: '订单列表', href: ''}
    ]
}, {
    title: '会员管理',
    iconCls: 'User',
    subMenu: [
        {id: 'menu-member-list', title: '会员列表', href: '/users/index.html'},
        {id: 'menu-member-card', title: '会员卡管理', href: ''}
    ]
}, {
    title: '商品信息',
    iconCls: 'Cart',
    selected: true,
    subMenu: [
        {id: 'menu-goods-purchase', title: '商品采购单', href: '/goods/purchase/index.html'},
        {id: 'menu-goods-list', title: '商品列表', href: '/goods/index.html'},
        {id: 'menu-goods-category', title: '商品类目', href: '/goods/category/index.html'},
        {id: 'menu-supplier-list', title: '供应商信息', href: '/supplier/index.html'}
    ]
}, {
    title: '促销管理',
    iconCls: 'Coins',
    subMenu: [
        {id: 'menu-point-manager', title: '积分管理', href: ''},
        {id: 'menu-point-exchange', title: '积分礼品', href: ''},
        {id: 'menu-coupon', title: '优惠券', href: ''},
        {id: 'menu-promotion', title: '买满送', href: ''}
    ]
}, {
    title: '数据统计',
    iconCls: 'Chartbar',
    subMenu: [
        {id: 'menu-daily-price', title: '每次菜价', href: ''},
        {id: 'menu-ecobag', title: '购物袋使用频率', href: ''}
    ]
}, {
    title: '基础数据',
    iconCls: 'Table',
    subMenu: [
        {id: 'menu-message-push', title: '消息推送', href: ''},
        {id: 'menu-area', title: '社区数据维护', href: ''}
    ]
}, {
    title: '系统功能',
    iconCls: 'Cog',
    subMenu: [
        {id: 'menu-admin-permissions', title: '功能权限', href: '/permissions/index.html'},
        {id: 'menu-admin-roles', title: '系统角色', href: '/roles/index.html'},
        {id: 'menu-admin-account', title: '账号管理', href: ''}
    ]
}];

// 添加 TabPanel
function addTabPanel(option) {
    // 查询 id 对应的 panel 是否已存在
    var tabs = $.grep($('#tabContent').tabs('tabs'), function (tab) {
        return option.id == tab.panel('options').id;
    });

    if ($.isEmptyObject(tabs)) {
        $('#tabContent').tabs('add', {
            id: option.id,
            title: option.title,
            href: option.href,
            closable: true
        });
    } else {
        $('#tabContent').tabs('select', option.title);
        if (!!option.reload) {
            var tab = $('#tabContent').tabs('getSelected');  // get selected panel
            tab.panel('refresh', option.href);
        }
    }
}

// 关闭最后一个Tabs按钮
function closeCurrentTab() {
    var tabs = $('#tabContent').tabs('tabs');
    if (tabs.length > 1) {
        $('#tabContent').tabs('close', tabs.length - 1);
    }
}

$(function () {

    // 添加导航栏
    $.each(navbar, function (i, e) {
        var datalist = $('<ul/>').addClass('easyui-datalist').css('width', '100%').attr('border', 'false');
        // 面板里面添加 datalist
        $.each(e.subMenu, function (index, subMenu) {
            var dataValue = $('<li/>').attr('value', subMenu.id).text(subMenu.title);
            datalist.append(dataValue);
        });

        $('#sider-navbar').accordion('add', {
            title: e.title,
            iconCls: e.iconCls,
            selected: !!e.selected,
            content: datalist
        });
    });

    // datalist 添加选择事件
    $('.easyui-datalist').datalist({
        onSelect: function (index, row) {
            $.each(navbar, function (i, e) {
                $.each(e.subMenu, function (index, subMenu) {
                    if (subMenu.id == row.value) {
                        addTabPanel(subMenu);
                    }
                });
            });
        }
    });
});


