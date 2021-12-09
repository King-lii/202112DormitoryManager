<%--
  Created by IntelliJ IDEA.
  User: lidada
  Date: 2021/12/9
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>修改密码</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${cb}/resources/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${cb}/resources/css/public.css" media="all" />
</head>
<body class="childrenBody">
<form class="layui-form layui-row changePwd" id="pwdLay" action="${cb}/login/updPwd.action">
    <div class="layui-col-xs12 layui-col-sm6 layui-col-md6">
        <div class="layui-input-block layui-red pwdTips">注意：新密码必须两次输入一致才能提交</div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" value="${user.realname}" disabled class="layui-input layui-disabled">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">旧密码</label>
            <div class="layui-input-block">
                <input type="password" name="pwd" value="" placeholder="请输入旧密码" lay-verify="required|oldPwd" class="layui-input pwd">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">新密码</label>
            <div class="layui-input-block">
                <input type="password" name="newpwd" value="" placeholder="请输入新密码" lay-verify="required|newPwd" id="oldPwd" class="layui-input pwd">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">确认密码</label>
            <div class="layui-input-block">
                <input type="password"  name="newpassword" value="" placeholder="请确认密码" lay-verify="required|confirmPwd" class="layui-input pwd">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="changePwd">立即修改</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </div>
</form>
<script type="text/javascript" src="${cb}/resources/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['jquery','form','layer','laydate','table','laytpl'],function(){
            var $ = layui.jquery;
            var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery,
            laydate = layui.laydate,
            laytpl = layui.laytpl,
            table = layui.table;
        //添加验证规则
        form.verify({
            oldPwd : function(value, item){
                var checkResult='';
                $.ajax({
                    url: "${cb}/login/judgeUser.action",
                    type: "GET",
                    data: {pwd:value},
                    async: false,
                    success: function(result) {
                        if(result==0){
                            checkResult = "密码错误！";
                        }
                    },
                    error: function() {
                    }
                });

                return checkResult;
            },
            newPwd : function(value, item){
                if(value.length < 6){
                    return "密码长度不能小于6位";
                }
            },
            confirmPwd : function(value, item){
                if(!new RegExp($("#oldPwd").val()).test(value)){
                    return "两次输入密码不一致，请重新输入！";
                }
            }
        })

        //控制表格编辑时文本的位置【跟随渲染时的位置】
        $("body").on("click",".layui-table-body.layui-table-main tbody tr td",function(){
            $(this).find(".layui-table-edit").addClass("layui-"+$(this).attr("align"));
        });
    })
</script>
</body>
</html>
