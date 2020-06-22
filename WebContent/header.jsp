<%@ page pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
<% User loginUser = (User)session.getAttribute("loginUser");
String comand = "";
if (null == loginUser){
	comand = "login";
} else {
	comand= "update";
}
%>
<header>
	<div class="logo">
		<a href="/MyKakeibo/" class="logolink">My家計簿</a>
	</div>
	<div class="header_menu">
			<div id="target"><i class="fas fa-bars fa-2x icon"></i></div>
			<div id="target2"><a href="/MyKakeibo/User?comand=<%=comand %>"><i class="far fa-user fa-2x icon"></i></a></div>
	</div>
	<nav class="nav" id="nav_f">
		<ul>
			<li><a href="/MyKakeibo/HouseholdAccount?comand=detail" class="list">家計簿を見る</a></li>
			<li><a href="/MyKakeibo/HouseholdAccount?comand=insert" class="list">家計簿を入力する</a></li>
			<li><a href="/MyKakeibo/HouseholdAccount?comand=edit" class="list">家計簿を編集する</a></li>
			<% if (loginUser != null) {%>
				<li><a href="/MyKakeibo/User?comand=logout" class="list">ログアウト</a></li>
			<% } %>
		</ul>
	</nav>
<script type="text/javascript" src="kakeibo.js"></script>
</header>