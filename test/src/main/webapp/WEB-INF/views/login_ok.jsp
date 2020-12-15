<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인성공</title>
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
<h1>로그인 성공!!!!</h1>
<p>아이디: <c:out value="${id }"/></p>
<p>비밀번호: <c:out value="${password }"/></p>

<a href="home" >목록으로</a>
</body>
</html>





