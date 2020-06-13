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
		<form action="/MyKakeibo/Login" method="post" class="form" id="round_border-white_back">
			ユーザー名<br>
			<input type="text" name=user_name id="white_line-round_border"><br><br>
			パスワード<br>
			<input type="text" name=password id="white_line-round_border"><br><br>
			<input type="submit" value="ログイン" id="white_line-round_border">
		</form>
		<p><a href="/MyKakeibo/Signup">ユーザー登録はこちら</a></p>
	</div>

</body>
</html>