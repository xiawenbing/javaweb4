<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	img{
		width:100%;
		height:100%;
		cursor:pointer;
	}
	.download{
		font-weight:bolder;
	}
	.mainJPG{
		margin:80px auto;
	}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">SummerDownload</a>
			</div>			
			<div>
				<ul class="nav navbar-nav">
					<li><a href="#">首页</a></li>
					<li><a href="${pageContext.request.contextPath}/jsp/userjsp/download.jsp" class="download" >资源下载</a></li>
					<li><a href="../../manage.jsp" class="download" >用户管理</a></li>
					<li><a href="${pageContext.request.contextPath}/jsp/managerjsp/resource.html" class="download">资源管理</a></li>
					<li><a href="${pageContext.request.contextPath}/jsp/userjsp/userself.jsp" class="download">个人中心</a></li>
					<li><a href="#">关于</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container mainJPG">
   		<div class="jumbotron">
	        <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600940536860&di=0571eab7f15ba71ee2054fae5477f8e3&imgtype=0&src=http%3A%2F%2Fbpic.588ku.com%2Fback_pic%2F00%2F09%2F87%2F315630832fad803.jpg" title="主页面图片">
   		</div>
	</div>

</body>
</html>