<%--
  Created by IntelliJ IDEA.
  User: yx
  Date: 2018/7/5
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="true" %>
                <form id="ff" method="post" enctype="multipart/form-data">
                    <table>
                    <tr>
                    <td>轮播图描述:</td>
                    <td>
                        <input class="easyui-textbox" name="pictureDescription"/>
                    </td>
                    </tr>

                    <tr>
                    <td>轮播图状态</td>
                    <td>
                        <select id="cc" class="easyui-combobox" name="pictureStatus">
                            <option value="状态">---请选择---</option>
                            <option value="展示中">展示中</option>
                            <option value="未展示">未展示</option>
                        </select>
            </td>
        </tr>

        <tr>
            <td>上传轮播图</td>
            <td><input name="file" class="easyui-filebox"/>
            </td>
        </tr>

    </table>
</form>
