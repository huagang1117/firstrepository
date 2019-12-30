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
	<form action="restindex" method="post" name="actionname" id="actionname">
    	<input type="text" name="name" id="name" />
		<input type="text" name="age" id="age" />
		<input type="button" name="btn" id="btn" value="btn">
		<br/>
		<input type="submit" value="rest页面">
		<br/>
		<input type="button" name="kafkaproduce" id="kafkaproduce" value="kafka生产者" />
		<br/>
		<input type="button" name="kafkaconsume" id="kafkaconsume" value="kafka消费者" />
		<br/>
		<input type="button" name="error" id="error" value="error">
	</form>
</body>
<script type="text/javascript" src="<%=path %>/js/common/jquery-1.11.3.min.js" ></script>
<script>
    $(function(){
        $("#btn").click(function(){
            $.post("<%=path%>/getPerson",{name:$("#name").val()},function(data){
                alert(data);
            });
        });
        $("#error").click(function(){
            $("#actionname").attr('action','<%=path%>/testexception');
            $("#actionname").submit();
        });
        $("#kafkaproduce").click(function(){
            $("#actionname").attr('action','<%=path%>/produce');
            $("#actionname").submit();
        });
        $("#kafkaconsume").click(function(){
            $("#actionname").attr('action','<%=path%>/consume');
            $("#actionname").submit();
        });
    });
</script>
</html>