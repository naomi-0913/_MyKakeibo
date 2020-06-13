<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% User loginUser = (User) session.getAttribute("loginUser");
	String msg = (String) request.getAttribute("msg");
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
	<% if (loginUser == null) { %>
		<h2>ログイン</h2>
		<div class="container">
			<form action="/MyKakeibo/User" method="post" class="form" id="round_border-white_back">
				ユーザー名<br>
				<input type="text" name=user_name id="white_line-round_border"><br><br>
				パスワード<br>
				<input type="password" name=password id="white_line-round_border"><br><br>
				<input type="hidden" name="comand" value="login">
				<input type="submit" value="ログイン" id="white_line-round_border">
			</form>
			<p><a href="/MyKakeibo/User">ユーザー登録はこちら</a></p>
		</div>
	<% } else {%>
		<h2>ユーザー情報</h2>
		<div class="container">
			<form action="/MyKakeibo/User" method="post" class="form" id="round_border-white_back">
				ユーザー名<br>
				<input type="text" name=user_name id="white_line-round_border" value=<%= loginUser.getName() %>><br><br>
				パスワード<br>
				<input type="password" name=password id="white_line-round_border" value=<%= loginUser.getPass() %>><br><br>
				<input type="hidden" name="comand" value="update">
				<input type="submit" value="更新" id="white_line-round_border">
			</form>
		</div>
	<% } %>

</body>
</html>