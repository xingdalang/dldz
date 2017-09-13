<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title></title>
    <link rel="stylesheet" href="/css/login/common.css"/>
    <link rel="stylesheet" href="/css/login/login.css"/>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
    <script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://malsup.github.io/min/jquery.form.min.js"></script>
    <script type="text/javascript">
	    $(function(){
	    	$("#submit").click(function(){
	    		$.ajax({
	    			url: "/login",            
	    	        type: "POST",                      
	    	        data: $("#form").serialize(),
	    	        dataType: "json",
	    	        success: function (response) {
	    	        	if(response.result){
	    	        		window.location.href="/order/list";
	    	        	}else{
	    	        		alert(response.msg)
	    	        	}
	    	        },
	    	        fail: function (status) {
	    	        }
	    	    })
	    	})
	    })
    </script>
    
</head>
<body>
    <div id="login"></div>
    <div class="login_bg">
        <div id="logo">
            <img src="/img/login/logo.png" alt=""/>
        </div>
        <form id="form" action="/login">
            <div class="userName">
                <lable>用户名：</lable>
                <input type="text" name="username" placeholder="请输入用户名" pattern="[0-9A-Za-z]{6,16}" required/>
            </div>
            <div class="passWord">
                <lable>密&nbsp;&nbsp;&nbsp;码：</lable>
                <input type="password" name="pass" placeholder="请输入密码" pattern="[0-9A-Za-z]{6,25}" required/>
            </div>
            <div class="choose_box">
                <div>
                    <input type="checkbox" checked="checked" name="checkbox"/>
                    <lable>记住密码</lable>
                </div>
                <a href="newPassword.html">忘记密码</a>
            </div>
            <button class="login_btn" id="submit" type="button">登&nbsp;&nbsp;录</button>
        </form>
        <#--<div class="other_login">
            <div class="other"></div>
            <span>其他方式登录</span>
            <div class="other"></div>
        </div>
         <div class="other_choose">
            <a href="">
                <img src="images/qq.png" alt=""/>
            </a>
            <a href="">
                <img src="images/wx.png" alt=""/>
            </a>
            <a href="">
                <img src="images/wb.png" alt=""/>
            </a>
        </div> -->
    </div>
</body>
</html>