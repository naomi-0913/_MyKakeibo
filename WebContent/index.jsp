<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<% String msg = (String) request.getParameter("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta name="description" content="家計簿をWEB上で管理できます。">
<title>My家計簿</title>
<jsp:include page="/common.jsp" />
</head>
<body>
	<jsp:include page="/header.jsp" />
	<main>
		<!-- TOP背景画像 -->
		<div class="back_image">
			<p>
				月々の収入・支出を<br> ノートに書いてませんか？<br> My家計簿は、<br>
				簡単に家計管理をできるようにします。
			</p>
<%-- 			<% if (msg != null) { %>
			<p><%= msg %></p>
			<% } %> --%>
		</div>

	</main>
</body>
</html>