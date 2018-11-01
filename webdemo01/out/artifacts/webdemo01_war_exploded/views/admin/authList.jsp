<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>权限列表</title>
    <link rel="stylesheet" href="../../public/layui/css/layui.css">
</head>
<body>
<form class="layui-form" action="" style="  display: flex; ">
    <div class="layui-form-item">
        <label class="layui-form-label">权限名称</label>
        <div class="layui-input-block">
            <input type="text" name="name" required lay-verify="required" placeholder="请输入标题" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" style="width: 200px;">
        <label class="layui-form-label">选择框</label>
        <div class="layui-input-block">
            <select name="is_off" lay-verify="required">
                <option value="0">开启</option>
                <option value="1">关闭</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="findAuth">查询</button>
            <div  class="layui-btn layui-btn-normal  add_auth"  >新增</div>
        </div>

    </div>
</form>

<table class="layui-table" style="width: 90%">
    <colgroup>
        <col width="100">
        <col width="60">
        <col width="250">
        <col width="60">
    </colgroup>
    <thead>
    <tr>
        <th>权限名称</th>
        <th>加入时间</th>
        <th>权限路径</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>贤心</td>
        <td>2016-11-29</td>
        <td>人生就像是一场修行</td>
        <td >
            <button class="layui-btn layui-btn-sm">
                <i class="layui-icon"></i>
            </button>
            <button class="layui-btn layui-btn-sm ">
                <i class="layui-icon"></i>
            </button>
        </td>
    </tr>
    <tr>
        <td>贤心</td>
        <td>2016-11-29</td>
        <td>人生就像是一场修行</td>
        <td >
            <button class="layui-btn layui-btn-sm">
                <i class="layui-icon"></i>
            </button>
            <button class="layui-btn layui-btn-sm ">
                <i class="layui-icon"></i>
            </button>
        </td>
    </tr>
    </tbody>
</table>

<script src="../../public/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    //Demo
    layui.use('form', function () {
        var form = layui.form;

        //监听提交
        form.on('submit(findAuth)', function (data) {
            layer.msg(JSON.stringify(data.field));


            return false;
        });
    });

    $("add_auth").click(function(){

        <%
            request.setAttribute("path","views/admin/addAuth.jsp");
        %>

    });






</script>

</body>
</html>