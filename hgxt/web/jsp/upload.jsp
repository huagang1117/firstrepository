<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>对外开放接口.首页</title>
</head>
<body>
	<center><h1>欢迎!</h1></center>
	<center><h2>Welcome hgxt!</h2></center>
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file"><br>
		<input type="submit" value="submit">
	</form>
</body>
<script type="text/javascript" src="<%=path %>/js/common/jquery-1.11.3.min.js" ></script>
</html>