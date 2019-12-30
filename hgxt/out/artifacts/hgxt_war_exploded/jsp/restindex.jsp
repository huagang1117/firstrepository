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
	<form action="<%=path%>/rest/user/1" method="post">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="put">
	</form>

	<form action="<%=path%>/rest/user/1" method="post">
		<input type="submit" value="post">
	</form>

	<form action="<%=path%>/rest/user/1" method="get">
		<input type="submit" value="get">
	</form>

	<form action="<%=path%>/rest/user/1" method="post">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="delete">
	</form>

	<form action="<%=path%>/rest/jsonperson" method="post">
		<input type="button" name="btn" id="btn" value="jsonbtn">
	</form>
</body>
<script type="text/javascript" src="<%=path %>/js/common/jquery-1.11.3.min.js" ></script>
<script>
    $(function(){
        $("#btn").click(function(){
            $.post("<%=path%>/rest/jsonperson",{},function(data){
                alert(data.name);
            });
        });
    });
</script>
</html>