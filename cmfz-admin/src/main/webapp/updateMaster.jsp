<%--
  Created by IntelliJ IDEA.
  User: yx
  Date: 2018/7/5
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="true" %>
<form id="mff" method="post" enctype="multipart/form-data">
    <table>
            <input name="masterId" type="hidden"/>
        <tr>
            <td>上师法名:</td>
            <td>
                <input class="easyui-textbox"  name="masterName"/>
            </td>
        </tr>

        <tr>
            <td>上师电话:</td>
            <td>
                <input class="easyui-textbox"  name="masterPhone"/>
            </td>
        </tr>
        <tr>
            <td>上师简介:</td>
            <td>
                <input class="easyui-textbox"  name="masterSummer"/>
            </td>
        </tr>

        <tr>
            <td>头像</td>
            <td><input name="file" class="easyui-filebox"/>
            </td>
        </tr>

        <tr>
            <td>上师状态</td>
            <td>
                <select id="cc" class="easyui-combobox" name="masterGender">
                    <option >---请选择---</option>
                    <option value="健在">健在</option>
                    <option value="已故">已故</option>
                </select>
            </td>
        </tr>



    </table>
</form>
