<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/11 0011
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <p class="your-para">用户名 :</p><span id="message"></span>
    <input type="text" name="username" id="uname" class="tk">
    <p class="your-para">密码 :</p>
    <input type="password" name="pwd" value="password" id="pwd">
    <p class="your-para">确认密码 :</p><span id="pmes"></span>
    <input type="password" name="pwds" class="tk" id="pwds">
    <p class="your-para">电话 :</p><span id="tel"></span>
    <input type="text" name="tele" id="tele" class="tk">
    <div id="quertion">你的姓名是？</div></p><span id="ans"></span>
    <input type="text" name="answer" placeholder="answer" id="answer" class="tk"><br>
    <input type="button" value="确认" id="btn">
</form>
<form >
    <input type="button" value="退出">
</form>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
    $(function () {
        var un;
        var pwd;
        var pwds;
        var tele;
        var  answer;
        $(".tk").blur(function () {
            un = $("#uname").val()
            pwd=$("#pwd").val();
            pwds=$("#pwds").val();
            tele=$("#tele").val();
            answer=$("#answer").val()
            $.ajax({
                url:"/doRegister.do",
                type:"post",
                data:{"uname":un,"pwd":pwd,"pwds":pwds,"teles":tele,"answer":answer},
                success:function (result) {
                  /*  alert(result)*/
                    if(result=="1"){
                        $("#message").text("可以注册");
                        $("#btn").attr("disabled",true);
                    }
                    if(result=="2"){
                        $("#message").text("用户已存在");
                        $("#btn").attr("disabled",true);
                    }
                    if(result=="3"){
                        $("#pmes").text("两次密码不一致");
                        $("#btn").attr("disabled",true);
                    }
                    if(result=="4"){
                        $("#pmes").text("√");
                        $("#btn").attr("disabled",true);
                    }
                    if(result=="5"){
                        $("#tel").text("√");
                        $("#btn").attr("disabled",true);
                    }
                    if(result=="6"){
                        $("ans").text("√");
                        $("#btn").attr("disabled",true);
                    }
                    alert(result)
                }
            })
        })
        $("#btn").click(function () {
            $.ajax({
                url: "doRegister.do",
                type:"post",
                data:{"uname":un,"pwd":pwd,"pwds":pwds,"teles":tele,"answer":answer},
                success:function (data) {
                    if(data>0){
                        alert("注册成功")
                        window.location.href="http://localhost/webManager/login"
                    }
                }
            });

        })

    })
</script>
</body>
</html>
