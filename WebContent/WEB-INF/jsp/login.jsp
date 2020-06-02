<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ログイン</title>
<jsp:include page="/common.jsp" />
</head>
<body>
	<jsp:include page="/header.jsp" />
	<h2>ログイン</h2>
	<div class="container">
		<form action="/MyKakeibo/Login" method="post" class="form">
			ユーザー名<br>
			<input type="text" name=userName><br><br>
			パスワード<br>
			<input type="text" name=password><br><br>
			<input type="submit" value="ログイン" id="submit">
		</form>
		<p><a href="/MyKakeibo/Signup">ユーザー登録はこちら</a></p>
	</div>

</body>
</html>