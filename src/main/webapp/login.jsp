<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html><html>
<head>
    <title>客户关系管理系统</title>

    <!-- 页面基本设置禁止随意更改 -->
    <meta charset="utf-8">
    <meta name="author" content="forework">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="msapplication-tap-highlight" content="no">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <script type="text/javascript" src="./plugin/jquery-easyui/jquery.min.js"></script>
    <!-- 页面基本设置禁止随意更改 -->
    <!-- 基础CSS类库可随意更改 -->
    <link rel="stylesheet" type="text/css" href="css/less.css">
    <link rel="stylesheet" type="text/css" href="css/basic.css">
    <!--[if IE 8]>
    <link rel="stylesheet" type="text/css" href="css/ie8.css">
    <![endif]-->
    <!--[if gte IE 9]>
    <link rel="stylesheet" type="text/css" href="css/ie.css">
    <![endif]-->
    <script type="text/javascript">
        $(document).keyup(function (event) {
            console.log(event.keyCode)
            if (event.keyCode == 13) {
                loginForm();
            }
        });

        function loginForm() {
            $.post("/login", $("form").serialize(), function (data) {
                if (data.success) {
                    window.location.href = "/index";
                } else {
                    alert(data.msg)
                }
            }, "json");
        }
    </script>
</head>
<body>
<div class="wrapper" style="background-color: white;">
    <div class="login-top">
        <div style="height: 60px;background-color: white;">
            <div style=";margin-left: 160px;">
                <img src="images/147084611429709d.png" width="300" height="60"/>
            </div>
        </div>
        <form id="loginform" method="post">
            <div class="login-topBg">
                <div class="login-topBg1">

                    <div class="login-topStyle">

                        <!--在点击注册时出现样式login-topStyle3登录框，而login-topStyle2则消失-->
                        <div class="login-topStyle3" id="loginStyle" style="margin-top: 75px;">
                            <h3>用户平台登录</h3>
                            <!--输入错误提示信息，默认是隐藏的，把display:none，变成block可看到-->
                            <div class="error-information" style="display:none;">您输入的密码不正确，请重新输入</div>
                            <div class="ui-form-item loginUsername">
                                <input type="username" name="username" value="admin" placeholder="用户名">
                            </div>
                            <div class="ui-form-item loginPassword">
                                <input type="password" name="password" value="1" placeholder="请输入密码">
                            </div>
                            <span class="error_xinxi" style="display:none;">您输入的密码不正确，请重新输入</span> <a
                                class="btnStyle btn-register" onClick="loginForm()"> 立即登录</a></div>
                    </div>
                </div>
            </div>
        </form>


    </div>
    <div class="loginCen" style="margin-top: 55px;">
        <div class="login-center">
            <div class="loginCenter-moudle">
                <div class="loginCenter-moudleLeft" style="margin-right: 60px;"> &nbsp;</div>
                <div class="loginCenter-moudleRight" style="  width: 1067px;">
                    <!--第一个-->
                    <a class="loginCenter-mStyle loginCenter-moudle1" id="moudleRemove"
                       style=" display:block;width: 340px;">
                        <span class="moudle-img"> <img src="images/login_bg_01.png"> </span>
                        <span class="moudle-text">
            <span class="moudle-text1" style="font-family:'微软雅黑'">客户管理
</span> 
            <span class="moudle-text2" style="font-family:'微软雅黑'">customer</span> 
            </span>
                    </a>
                    <!--第二个-->
                    <a class="loginCenter-mStyle loginCenter-moudle2" style=" display:block; width: 357px;"
                       id="moudleRemove2">
                        <span class="moudle-img"> <img src="images/login_bg_02.png"> </span>
                        <span class="moudle-text">
            <span class="moudle-text1" style="font-family:'微软雅黑'"> 订单合同审核
</span>
            <span class="moudle-text2" style="font-family:'微软雅黑'">orderBill</span> 
           </span>
                    </a>
                    <!--第三个-->
                    <a class="loginCenter-mStyle loginCenter-moudle3" style=" display:block;" id="moudleRemove3">
                        <span class="moudle-img"> <img src="images/login_bg_03.png"> </span>
                        <span class="moudle-text">
                 <span class="moudle-text"> <span class="moudle-text1" style="font-family:'微软雅黑'">报表
</span>
                  <span class="moudle-text2" style="font-family:'微软雅黑'">PotentialCustomerChart</span>
            </span>
            </span>
                    </a>

                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>