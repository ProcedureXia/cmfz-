<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $("#master_add").linkbutton({
            onClick: function () {
                $('#master_dd').dialog({
                    title: '添加上师',
                    width: 400,
                    height: 200,
                    close: true,
                    href: '${pageContext.request.contextPath}/addMaster.jsp',
                    onLoad: function () {
                        $("#mmff").form('load', rowData);
                    },
                    buttons: [{
                        text: '添加',
                        iconCls:"icon-save",
                        handler: function () {
                            $("#mmff").form("submit", {
                                url: '${pageContext.request.contextPath}/addMaster',
                                success: function (e) {
                                    $('#master_dg').datagrid('reload');
                                    $('#master_dg').dialog('close');
                                }
                            });
                        }
                    }, {
                        text: '关闭',
                        iconCls:"icon-cancel",
                        handler: function () {
                            $.messager.show({
                                title:"添加上师退出成功",
                                msg:"您已经取消添加上师，如需添加上师，请再次操作",
                                timeout:5000,
                            });
                            $('#master_dd').dialog('close');
                        }
                    }],
                });
            }
        });

        $("#master_moreadd").linkbutton({
            onClick: function () {
                $('#master_dd').dialog({
                    title: '添加上师',
                    width: 400,
                    height: 200,
                    close: true,
                    href: '${pageContext.request.contextPath}/uploadMasters.jsp',
                    onLoad: function () {
                        $("#uploadMaster").form('load', rowData);
                    },
                    buttons: [{
                        text: '添加',
                        iconCls:"icon-save",
                        handler: function () {
                            $("#uploadMaster").form("submit", {
                                url: '${pageContext.request.contextPath}/importExcel',
                                success: function (e) {
                                    $('#master_dg').datagrid('reload');
                                    $('#master_dg').dialog('close');
                                }
                            });
                        }
                    }, {
                        text: '关闭',
                        iconCls:"icon-cancel",
                        handler: function () {
                            $.messager.show({
                                title:"添加上师退出成功",
                                msg:"您已经取消添加上师，如需添加上师，请再次操作",
                                timeout:5000,
                            });
                            $('#master_dd').dialog('close');
                        }
                    }],
                });
            }
        });


        $("#master_update").linkbutton({
            onClick: function () {
                var rowData = $("#master_dg").datagrid('getSelected');
                $('#master_dd').dialog({
                    title: '修改上师',
                    width: 400,
                    height: 200,
                    href: '${pageContext.request.contextPath}/updateMaster.jsp',
                    onLoad:function(){
                        $("#mff").form("load",rowData);
                    },

                    buttons: [{
                        text: '修改',
                        iconCls:"icon-save",
                        handler: function () {
                            $("#mff").form("submit", {
                                url: '${pageContext.request.contextPath}/modifyMaster',
                                success: function (e) {
                                    $('#master_dg').datagrid('reload');
                                    $('#master_dg').dialog('close');
                                }
                            });
                        }
                    }, {
                        text: '关闭',
                        iconCls:"icon-cancel",
                        handler: function () {
                            $.messager.show({
                                title:"修改上师退出成功",
                                msg:"您已经取消修改上师，如需修改上师，请再次操作",
                                timeout:5000,
                            });
                            $('#master_dd').dialog('close');
                        }
                    }],

                });
            }
        });



        $('#master_dg').datagrid({
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
            url : "${pageContext.request.contextPath}/queryAllMaster",
            columns: [[
                {field: 'masterId', title: '上师编号', width: '16%'},
                {field: 'masterName', title: '上师法名', width: '16%'},
                {field: 'masterPhone', title: '上师电话', width: '16%'},
                {field: 'masterSummer', title: '上师简介', width: '20%'},
                {field: 'masterPhoto', title: '上师头像', width: '16%'},
                {
                    field: 'masterGender', title: '状态', width: '16%',
                    formatter: function (value, row, index) {
                        if (value == '已故') {
                            return '<span style="color: red;">已故</span>';
                        } else {
                            return '<span>健在</span>';
                        }
                    }
                },

            ]],


            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.masterPhoto + '" style="height:50px;"></td>' +
                    '</tr></table>';
            }
        });

        $('#ss1').searchbox({
            searcher : function(value, name) {
             //   alert(value+" "+name);
                $("#master_dg").datagrid("load",{
                    key : name,
                    value : value,
                });

             //   alert(11111111111111);
                $("#master_dg").datagrid({
                    url:"${pageContext.request.contextPath}/queryMasterByKey",
                });
            },
            menu : '#mm1',
            prompt : '请输入模糊查询的值',
            width:	300,
        });


    });
</script>


<table id="master_dg"/>
<div id="master_tb">
    <a id="master_add" class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'添加'"></a>
    <a id="master_update" class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'修改'"></a>
    <a id="master_moreadd" class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'批量插入'"></a>
    <div id="mm1">
        <div data-options="name:'masterName',iconCls:'icon-save'">上师法名</div>
        <div data-options="name:'masterPhone',iconCls:'icon-save'">上师电话</div>
        <div data-options="name:'masterGender',iconCls:'icon-save'">状态</div>
    </div>
    <table id="dg1">
        <input id="ss1"/>
    </table>
    <div id="master_dd"></div>
</div>




