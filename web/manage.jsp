<%--
  Created by IntelliJ IDEA.
  User: 夏文昺
  Date: 2020/10/30
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserManger</title>
    <script src="js/jquery-3.5.0.min.js"></script>
    <script src="js/userManger.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        .download{
            font-weight:bolder;
        }
        a{
            cursor:pointer;
        }

        #pageBody{
            margin: 80px auto;
            width: 800px;
        }

        #search{
            margin-bottom: 5px;
            height: 60px;
        }
        #searchForm{
            float: left;
        }
        #searchForm input{
            width: 150px;
            height: 33px;
        }
        #bt{
            float: right;
        }

        table{
            margin-bottom: 50px;
        }

        #paging{
            margin-bottom: 50px;
        }
        .pageSize{
            float: left;
        }
        #pageNav{
            float: right;
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
                <li><a href="${pageContext.request.contextPath}manage.jsp" class="download" >用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/managerjsp/resource.html" class="download">资源管理</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/userjsp/userself.jsp" class="download">个人中心</a></li>
                <li><a href="#">关于</a></li>
            </ul>
        </div>
    </div>
</nav>

<div id="pageBody">
    <div id="search">
        <form id="searchForm">
            <input type="text" name="userName" placeholder="输入用户名..."/>
            <input type="text" name="chrName" placeholder="输入中文名..."/>
            <input type="text" name="password" placeholder="输入密码..."/>
            <input type="text" name="role" placeholder="输入角色..."/>
        </form>
        <div id="bt">
            <a href="#" id="btSearch" class="btn btn-primary">查找</a>
            <a href="#" id="btClear" class="btn btn-success">清空</a>
            <a href="#" id="btAdd" class="btn btn-info">增加</a>
            <a href="#" id="btDelete" class="btn btn-danger">删除</a>
            <a href="#" id="btUpdate" class="btn btn-warning">修改</a>
        </div>
    </div>

    <table>
        <thead>
        <tr>
            <th width="40"><input type="checkbox" id="ckAll" title="选择"/></th>
            <th width="100" id="sortByUserName" data="userName">用户名</th>
            <th width="110">姓名</th>
            <th width="100">密码</th>
            <th width="70">角色</th>
            <th width="120">操作</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>

    <div id="paging">
        <div class="pageSize">每页
            <select id="pageSize">
                <option selected>5</option>
                <option>10</option>
                <option>20</option>
            </select>条数据，共
            <span id="total"></span>条数据，
            <span id="pageNumber">1</span>页/<span id="pageCount"></span>页
        </div>
        <div id="pageNav">
            <a id="first" href="#">首页</a>
            <a id="back" href="#">上一页</a>
            <a id="next" href="#">下一页</a>
            <a id="last" href="#">尾页</a>
        </div>
    </div>
</div>
</body>
</html>
