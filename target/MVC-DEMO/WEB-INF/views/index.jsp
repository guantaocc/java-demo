<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2025/2/26
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <form method="post" action="${pageContext.request.contextPath}/upload/test" enctype="multipart/form-data">
     username: <input type="username" name="username">
     file: <input type="file" name="source">
     <input type="submit" value="提交">
 </form>
</body>
</html>
