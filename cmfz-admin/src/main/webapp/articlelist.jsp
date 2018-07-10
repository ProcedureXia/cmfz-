<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $('#article_dg').datagrid({
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
            url : "${pageContext.request.contextPath}/queryAllArticle",
            columns: [[
                {field: 'articleId', title: '文章编号', width: '16%'},
                {field: 'articleName', title: '文章名', width: '16%'},
                {field: 'articleContent', title: '文章内容', width: '16%'},
                {
                    field: 'articleStatus', title: '文章状态', width: '15%',
                    formatter: function (value, row, index) {
                        if (value == 'on') {
                            return '<span style="color: red;">上架</span>';
                        } else {
                            return '<span>下架</span>';
                        }
                    }
                },
                {
                    field: 'articleDate', title: '文章创建时间', width: '20%',
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
                {
                    field: 'operation',
                    title: '操作',
                    width: '15%',
                    formatter: function (value, row, index) {
                        var str = '<a name="update"></a>';
                        return str;
                    }
                }
            ]],

            onLoadSuccess: function () {
               /* $("a[name='detail']").linkbutton({
                    text: '详情',
                    plain: false,
                    iconCls: 'icon-edit',
                });*/

                $("a[name='update']").linkbutton({
                    text: '修改',
                    plain: false,
                    iconCls: 'icon-edit',
                    onClick:function () {
                        var rowData = $("#article_dg").datagrid('getSelected');
                        $('#article_dd').dialog({
                            title: '修改文章信息',
                            width: 400,
                            height: 200,
                            href: '${pageContext.request.contextPath}/updateArticle.jsp',
                            onLoad: function () {
                                $("#article_ff1").form('load', rowData);
                            },
                            buttons: [{
                                text: '修改',
                                iconCls:"icon-save",
                                handler: function () {
                                    $("#article_ff1").form("submit", {
                                        url: '${pageContext.request.contextPath}/modifyArticle',
                                        success: function (e) {
                                            console.log(e);
                                            $('#article_dg').datagrid('reload');
                                            $('#article_dd').dialog('close');
                                        }
                                    });

                                }
                            }, {
                                text: '关闭',
                                iconCls:"icon-cancel",
                                handler: function () {
                                    $.messager.show({
                                        title:"修改文章退出成功",
                                        msg:"您已经取消修改文章，如需修改文章，请再次操作",
                                        timeout:3000,
                                    });
                                    $('#article_dd').dialog('close');
                                }
                            }],
                        });
                    }
                });
            },
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.articleContent + '" style="height:50px;"></td>' +
                    '</tr></table>';
            }
        });

    });
</script>

<div id="article_dd"></div>
<table id="article_dg"></table>
