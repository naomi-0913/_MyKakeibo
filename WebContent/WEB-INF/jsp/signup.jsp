<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>新規登録</title>
<jsp:include page="/common.jsp" />
</head>
<body>
	<jsp:include page="/header.jsp" />
	<h2>新規登録</h2>
	<div class="container">
		<form action="Signup" method="post" class="form">
			ユーザー名<br> <input type="text" name=userName><br><br>
			パスワード<br> <input type="text" name=password><br><br>
			<input type="submit" value="登録" id="submit">
		</form>
	</div>
</body>
</html>