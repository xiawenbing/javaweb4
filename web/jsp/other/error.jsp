<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	body{
		max-width:500px;
		margin:20px auto;
	}
</style>
<script>
	window.onload=function(){
		var timer = setInterval(function(){
			$("time").innerText-=1;
			
			// 倒计时结束跳转到index.jsp
			if($("time").innerText==="0"){
				clearInterval(timer);
                //跳转
                window.location.href="../../index.jsp"
                
			}
		},1000);
		
		 function $(id) {
             return typeof id === "string" ? document.getElementById(id) : null;
         }
	}
</script>
</head>
<body>
	<%
		String errorInf = (String)request.getAttribute("errorInf");
	%>
	<div class="panel panel-default">
		<div class="panel-heading">Something wrong!</div>
		<div class="panel-body">
			<div>
				<h3>${requestScope.errorInf }页面将在<span id="time">5</span>秒后跳转</h3>		
			</div>
			<div>点击<a href="http://localhost:8080/javaweb2/"> 这里 </a>直接跳转</div>
		</div>
	</div>
	
	
</body>
</html>