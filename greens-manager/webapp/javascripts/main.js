/**
 * Created by ytwman on 16/9/5.
 */

$(function () {
    // 警告条延时关闭
    $('.alert').delay(2000).fadeOut(500);

    // 删除模块
    new Vue({
        el: 'body',
        data: {
            dialog: {
                delete: {}
            }
        },
        methods: {
            showDeleteModal: function () {
                $('#deleteModal').modal('show');
            }
        }
    });
});
