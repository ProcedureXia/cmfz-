<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $('#log_dg').datagrid({
            pagination: true,
            pageList: [5, 10, 15],
            fitColumns: true,
            singleSelect: true,
            remoteSort: false,
            nowrap: false,
            pageSize: 5,
            striped: true,
            toolbar: '#tb',
            resizeHandle: 'both',
            url : "${pageContext.request.contextPath}/queryAllLog",
            columns: [[
                {field: 'logId', title: '日志编号', width: '15%'},
                {field: 'user', title: '管理员', width: '15%'},
                {field: 'time', title: '操作时间', width: '15%',
                    formatter: function (value, row, index) {
                        var date = new Date(value);
                        var year = date.getFullYear();
                        var month = date.getMonth() + 1;
                        var day = date.getDate();
                        var hour = date.getHours();
                        var minutes = date.getMinutes();
                        var seconds = date.getSeconds();
                        return year + "年" + month + "月" + day + "日" + "\t" + hour + ":" + minutes + ":" + seconds;
                    }
                },
                {field: 'resource', title: '资源类型', width: '10%'},
                {field: 'action', title: '操作动作', width: '15%'},
                {field: 'message', title: '操作内容', width: '20%'},
                {field: 'result', title: '操作结果', width: '10%'},

            ]],
        });
    });
</script>

<table id="log_dg"/>




