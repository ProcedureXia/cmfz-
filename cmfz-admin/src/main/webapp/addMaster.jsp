<%--
  Created by IntelliJ IDEA.
  User: yx
  Date: 2018/7/5
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="true" %>
                <form id="mmff" method="post" enctype="multipart/form-data">
                    <table>

                        <tr>
                            <td>上师姓名:</td>
                            <td>
                                <input class="easyui-textbox" name="masterName"/>
                            </td>
                        </tr>

                        <tr>
                            <td>上师电话:</td>
                            <td>
                                <input class="easyui-textbox" name="masterPhone"/>
                            </td>
                        </tr>
                        <tr>
                    <td>上师简介:</td>
                    <td>
                        <input class="easyui-textbox" name="masterSummer"/>
                    </td>
                    </tr>

                        <tr>
                            <td>头像</td>
                            <td><input name="file" class="easyui-filebox"/>
                            </td>
                        </tr>
                    <tr>
                    <td>状态</td>
                    <td>
                        <select id="cc" class="easyui-combobox" name="masterGender">
                            <option>---请选择---</option>
                            <option >健在</option>
                            <option >已故</option>
                        </select>
            </td>
        </tr>

    </table>
</form>
