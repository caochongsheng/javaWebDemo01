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
<form class="layui-form" method="post" action="/admin?method=addAdminUser" style="width: 50%;">
    <div class="layui-form-item">
        <label class="layui-form-label">权限名称</label>
        <div class="layui-input-block">
            <input type="text" name="name" required lay-verify="required" placeholder="请输入标题" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item"  >
        <label class="layui-form-label">所属</label>
        <div class="layui-input-block">
            <select name="pid" lay-verify="required">
                <option value="0">开启</option>
                <option value="1">关闭</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">控制器</label>
        <div class="layui-input-block">
            <input type="text" name="controller" required lay-verify="required" placeholder="控制器名称" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">方法</label>
        <div class="layui-input-block">
            <input type="text" name="action" required lay-verify="required" placeholder="方法名称" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">路径</label>
        <div class="layui-input-block">
            <input type="text" name="path" required lay-verify="required" placeholder="方法名称" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit  >提交</button>
        </div>
    </div>

</form>

<script src="../../public/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    //Demo
    layui.use('form', function () {
        var form = layui.form;
        // 监听 提交
        form.on('submit(addAdminUser)', function (data) {
            layer.msg(JSON.stringify(data.field));

            return false;
        });
    });
</script>

</body>
</html>