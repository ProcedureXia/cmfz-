<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $("#pic_add").linkbutton({
            onClick: function () {
                $('#dd').dialog({
                    title: '添加轮播图',
                    width: 400,
                    height: 200,
                    close: true,
                    href: '${pageContext.request.contextPath}/add.jsp',
                    buttons: [{
                        text: '添加',
                        iconCls:"icon-save",
                        handler: function () {
                            $("#ff").form("submit", {
                                url: '${pageContext.request.contextPath}/addPicture',
                                success: function (e) {
                                    $('#dg').datagrid('reload');
                                    $('#dd').dialog('close');
                                }
                            });
                        }
                    }, {
                        text: '关闭',
                        iconCls:"icon-cancel",
                        handler: function () {
                            $.messager.show({
                                title:"添加轮播图退出成功",
                                msg:"您已经取消添加轮播图，如需添加轮播图，请再次操作",
                                timeout:3000,
                            });
                            $('#dd').dialog('close');
                        }
                    }],
                });
            }
        });

        $('#dg').datagrid({
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
            url : "${pageContext.request.contextPath}/queryAllPicture",
            columns: [[
                {field: 'pictureId', title: '标识编号', width: '16%'},
                {field: 'pictureName', title: '文件名', width: '16%'},
                {field: 'pictureDescription', title: '轮播图描述信息', width: '16%'},
                {
                    field: 'pictureStatus', title: '轮播图状态', width: '15%',
                    formatter: function (value, row, index) {
                        if (value == '展示中') {
                            return '<span style="color: red;">展示中</span>';
                        } else {
                            return '<span>未展示</span>';
                        }
                    }
                },
                {
                    field: 'createTime', title: '轮播图创建时间', width: '20%',
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
                $("a[name='update']").linkbutton({
                    text: '修改',
                    plain: false,
                    iconCls: 'icon-edit',
                    onClick:function () {
                        var rowData = $("#dg").datagrid('getSelected');
                        $('#dd').dialog({
                            title: '修改图片信息',
                            width: 400,
                            height: 200,
                            href: '${pageContext.request.contextPath}/update.jsp',
                            onLoad: function () {
                                $("#ff1").form('load', rowData);
                            },
                            buttons: [{
                                text: '修改',
                                iconCls:"icon-save",
                                handler: function () {
                                    $("#ff1").form("submit", {
                                        url: '${pageContext.request.contextPath}/modifyPicture',
                                        success: function (e) {
                                            console.log(e);
                                            $('#dg').datagrid('reload');
                                            $('#dd').dialog('close');
                                        }
                                    });

                                }
                            }, {
                                text: '关闭',
                                iconCls:"icon-cancel",
                                handler: function () {
                                    $.messager.show({
                                        title:"修改轮播图退出成功",
                                        msg:"您已经取消修改轮播图，如需修改轮播图，请再次操作",
                                        timeout:3000,
                                    });
                                    $('#dd').dialog('close');
                                }
                            }],
                        });
                    }
                });
            },
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.pictureName + '" style="height:50px;"></td>' +
                    '</tr></table>';
            }
        });

    });
</script>
<table id="dg"></table>
<div id="tb">
    <a id="pic_add" class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'添加'"></a>
    <a id="pic_help" class="easyui-linkbutton" data-options="iconCls:'icon-help',text:'帮助'"></a>
</div>
<div id="dd"></div>

