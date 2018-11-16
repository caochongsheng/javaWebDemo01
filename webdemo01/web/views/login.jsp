<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="../public/layui/css/layui.css">
</head>
<body  >

              <h3>${msg}</h3>

<form class="layui-form" method="post" action="/login?method=login" style="width: 50%;margin-left: 25%;margin-top: 25%;">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="name" required lay-verify="required" placeholder="请输入标题" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="password" name="pwd" required lay-verify="required" placeholder="请输入标题" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="login"  >提交</button>
        </div>
    </div>

</form>

<script src="../public/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    //Demo

    layui.use('form', function () {
        var form = layui.form;

        //监听提交
        form.on('submit(login)', function (data) {
            layer.msg(JSON.stringify(data.field));

            return false;
        });
    });
</script>

</body>
</html>