<%--
  Created by IntelliJ IDEA.
  User: yx
  Date: 2018/7/8
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E("#div1");

    // 配置服务器端地址
     editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/addPic'  // 上传图片到服务器
    // 进行下文提到的其他配置
    editor.customConfig.uploadFileName = 'files' //上传文件的名称

    editor.create();


    function test(){
        $.post("${pageContext.request.contextPath}/addArticle",{
            articleName:$("#name1").val(),
            masterId:$("#cc").combobox("getValue"),
            articleContent:editor.txt.html(),
            articleStatus:$("#s").val(),
        },function(data){
           alert(data);
            $("#reset_art").form("reset");
        },"json");
    }


    function reset(){
    $("#reset_art").form("reset");
    }



     $(function(){
        $('#cc').combobox({
            url:'${pageContext.request.contextPath}/selectAllMaster',
            valueField:'masterId',
            textField:'masterName'
        });




        $(function(){
            $("#s").switchbutton({
                checked:false,
                value:'off',
                onChange:function(checked){
                   if(checked==true){
                       $(this).val('on');
                   }

                    if(checked==false){
                        $(this).val('off');
                    }
                }

            });

        });

    });

</script>

<form id="create_article" method="post" enctype="multipart/form-data" style="background-color: #f2c56d">
            <div>
            文章标题:
                    <input class="easyui-textbox" id="name1" name="articleName"/>
            </div>
                 <br>
            <div>
            文章作者:
                <input  id="cc" class="easyui-combobox" name="masterId" value="未知"/>
            </div>
                <br>
            <div>
            文章状态:
                    <input id= "s" class="easyui-switchbutton" data-options="onText:'上架',offText:'下架'" name="articleStatus">
            </div>
                <br>
            <div>
           文章内容:
                <div id="div1" name="articleContent">
                        <p>欢迎使用 wangEditor 富文本编辑器</p>
                </div>
            </div>
            <br>
            <a class="easyui-linkbutton" data-options="onClick:test">创建文章</a>
            <a class="easyui-linkbutton" data-options="onClick:reset">重置内容</a>
</form>
