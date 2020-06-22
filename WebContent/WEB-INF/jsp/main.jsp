<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% User loginUser = (User) session.getAttribute("loginUser");
	String msg = (String) request.getAttribute("msg");
	String comand = (String) request.getAttribute("comand");
%>
<!DOCTYPE html>
<html>
<head>
<title>My家計簿</title>
<jsp:include page="/common.jsp"/>
</head>
<body>
	<jsp:include page="/header.jsp"/>
	<% if (msg != null) { %>
		<h4><%= msg %></h4>
	<% } %>
	<% if ("login".equals(comand)) { %>
		<h2>ログイン</h2>
		<div class="container">
			<form action="/MyKakeibo/User" method="post" class="form round_border-white_back">
				ユーザー名<br>
				<input type="text" name=user_name id="white_line-round_border"><br><br>
				パスワード<br>
				<input type="password" name=password id="white_line-round_border"><br><br>
				<input type="hidden" name="comand" value="login">
				<input type="submit" value="ログイン" id="white_line-round_border">
			</form>
			<p><a href="/MyKakeibo/User?comand=signup">ユーザー登録はこちら</a></p>
		</div>
	<% } else if ("update".equals(comand)) {%>
		<h2>ユーザー情報</h2>
		<div class="container">
			<form action="/MyKakeibo/User" method="post" class="form round_border-white_back">
				ユーザー名<br>
				<input type="text" name=user_name id="white_line-round_border" value=<%= loginUser.getName() %>><br><br>
				パスワード<br>
				<input type="password" name=password id="white_line-round_border" value=<%= loginUser.getPass() %>><br><br>
				<input type="hidden" name="comand" value="update">
				<input type="submit" value="更新" id="white_line-round_border">
			</form>
		</div>
	<% } else if ("signup".equals(comand)) { %>
		<h2>新規登録</h2>
	<div class="container">
		<form action="/MyKakeibo/User" method="post" class="form round_border-white_back">
			ユーザー名<br> <input type="text" name=user_name id="white_line-round_border"><br><br>
			パスワード<br> <input type="text" name=password id="white_line-round_border"><br><br>
			<input type="hidden" name="comand" value="signup">
			<input type="submit" value="登録" id="white_line-round_border">
		</form>
	</div>
	<% } %>
</body>
</html>