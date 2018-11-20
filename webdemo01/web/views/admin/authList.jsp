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
        <col width="200">
        <col width="200">
        <col width="200">
        <col width="350">
        <col width="150">
    </colgroup>
    <thead>
    <tr>
        <th>权限名称</th>
        <th>控制器</th>
        <th>方法</th>
        <th>路径</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${auths}" var="auth">
        <tr>
            <td>${auth.name}</td>
            <td>${auth.controler}</td>
            <td>${auth.action}</td>
            <td>${auth.path}</td>
            <td >
                <button class="layui-btn layui-btn-sm">
                    <i class="layui-icon"></i>
                </button>
                <button class="layui-btn layui-btn-sm ">
                    <i class="layui-icon"></i>
                </button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<script src="../../public/layui/layui.js"></script>
<script src="../../public/js/jquery-1.11.3.min.js"></script>
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

    $(".add_auth").click(function(){
        console.log("xxxxxxxxxxxxxxxxxx");
        window.location.href = "/views/admin/addAuth.jsp";

    });






</script>

</body>
</html>