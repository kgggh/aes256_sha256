<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>암호화</title>
<style type="text/css">
.form{
	text-align: center;
	width: 100%;
	height: 100%;
}
div{
	display: inline-block;
}

#btn{
	padding-left: 10px;
	padding-right: 10px;
	
}
input {
	border: 1px solid black; 
}
#div1 input{
	width: 200px;
	height: 200px;
	text-align: center;
}
#div3 input{
	width: 200px;
	height: 200px;
	text-align: center;
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
<div class="form">
	<form name="frm1" method="post">
		<p>key <input type="text" placeholder="key" name="key"></p>
		<div id="div1">
			<p>input</p>
			<input type="text" value="<c:out value="${key }"/>" readonly="readonly">
		</div>
		
		<div id="btn">
			<p><input type="submit" onclick="this.form.action='encrypt';" value="암호화"></p>
			<input type="submit" onclick="this.form.action='decrypt';" value="복호화" >
		</div>
		
		<div id="div3">
			<p>output</p>
			<input type="text" value="<c:out value="${encrypt}"/>"readonly="readonly">
		</div>
	</form>
	<a href="home" >목록으로</a>
</div>
</body>

</html>