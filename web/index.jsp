
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>title</title>
  <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <script src="js/jquery-3.5.0.min.js"></script>
    <script src="js/login.js"></script>
</head>
<body>
  <div>
    <div class="bgDiv">
      <div class="login">

        <div class="username">
          <input  id="username" class="userInp" type="text" name="username" placeholder="用户名"/>
            <p> <span class="auth_err" id="userNameError"></span> </p>
        </div>


        <div class="pwd">
          <input id="password" class="pwdInp" type="password" name="password" placeholder="密码"/>
          <p>  <span class="auth_err" id="passwordError"></span> </p>
        </div>

         <div class="ywd">
          <input id="vcode"  name="vcode" placeholder="验证码">
           <img src="/demo1" id="verifyCode" onclick="changeCode()"><br>
           <input id="autoLogin" type="checkbox" name="autoLogin"> 一周免密登录<br>
            <P> <span class="auth_err" id="vcodeError"></span> </P>
         </div>
          <input class="btn" id="btLogin" type="button" value="登&nbsp;&nbsp;录 " onclick="jqAjaxCheckLogin();" />
        <P>  <span class="auth_err" id="checkError"></span></P>
          <span><a href="register.jsp">注册</a></span>
      </div>
    </div>
  </div>
</body>
</html>
