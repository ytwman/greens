$(function () {

    // 权限列表
    var roles = new Vue({
        el: '#roles-list',
        data: {
            roles: [],
            role: {}
        },
        methods: {
            addRole: function () {
                $.post(contextPath + "/roles/create", this.role, "json");
            },
            showRoleModify: function() {

            },
            roleModify: function () {
                $.post(contextPath + "/roles/modify", {_method: "put"}, initRoles);
            },
            showRoleDelete: function() {

            },
            roleDelete: function (roleId) {
                $.post(contextPath + "/roles/" + roleId, {_method: "delete"}, initRoles);
            }
        }
    });

    // 加载列表页面
    function initRoles() {
        $.get(contextPath + '/roles', function (data) {
            roles.roles = data;
        }, 'json');
    }

    initRoles();

    // 加载权限树页面
    $.get(contextPath + "/permissions", function (result) {
        var data = new Array();
        $.each(result, function (index, e) {
            data.push({id: e.id, text: e.name, parent: e.parentId == null ? "#" : e.parentId + ""});
        });

        // 添加页面渲染权限树
        $('#treeview').jstree({
            core: {
                multiple: true,
                data: data
            },
            sort: function (e1, e2) {
                return e1.sortby < e2.sortby;
            },
            plugins: ["wholerow", "checkbox", "sort"]
        });
    }, "json");
});