<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>资源下载</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">SummerDownload</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li><a href="#">首页</a></li>
					<li><a href="download.jsp">下载</a></li>
					<li><a href="#">设计</a></li>
					<li><a href="#">相册</a></li>
					<li><a href="#">论坛</a></li>
					<li><a href="#">关于</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="panel panel-default">
		<div class="panel-heading">The All Of Download List :</div>
		<div class="panel-body">
			<div class="list-group">

				<c:if test="${empty downlist}">
					out.write("没有下载项！");
				</c:if>
				
				<c:forEach items="${downlist }" var="dao">
					<a href="javaweb2/demo/Servlet2?id=${dao.id }" class="list-group-item">
						<h4>id号：${dao.id } </h4>
						<p>下载文件名称：${dao.name }</p>
					</a>
				</c:forEach>
		
				<a href="#" class="list-group-item">

				</a>
			</div>
		</div>
	</div>

	
</body>
</html>