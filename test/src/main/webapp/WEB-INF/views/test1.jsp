<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test1</title>
<style type="text/css">

.form{
	height: 100%;
	width: 100%;
	text-align: center;
}

</style>
<script type="text/javascript">

</script>
</head>
<body>
<div class="form">
	<form action="login" method="post">
		<p>아이디 <input type="text" name="id"><p>
		<p>비밀번호 <input type="password" name="password"><p>
		<input type="submit" value="로그인">
	</form>
	<a href="home" >목록으로</a>
</div>
</body>
</html>





