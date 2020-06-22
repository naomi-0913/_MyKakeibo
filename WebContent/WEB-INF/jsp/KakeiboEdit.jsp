<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Kakeibo" %>
<% List<Kakeibo> kakeiboList = (List<Kakeibo>) request.getAttribute("kakeiboList");
String date = (String) request.getAttribute("date");
BigDecimal totalIncome = new BigDecimal("0");
BigDecimal totalOutcome = new BigDecimal("0");
%>
<!DOCTYPE html>
<html>
<head>
<title>家計簿</title>
<jsp:include page="/common.jsp" />
</head>
<body>
	<jsp:include page="/header.jsp" />
	<div class="title_wrapper ">
		<h3><%= date %>月の収入</h3>
		<h3><%= date %>月の支出</h3>
	</div>
	<main>
		<div class="large_container">
			<div class="wrapper">
					<section class="details round_border-white_back wrapper">
					<% for(Kakeibo kakeiboInfo: kakeiboList){ %>
						<% if("収入".equals(kakeiboInfo.getmoneyType())) {%>
							<form class="edit_form" action="/MyKakeibo/HouseholdAccount" method="post">
								<input id="white_line-round_border" type="text" name="category" value=<%= kakeiboInfo.getCategory()%>>
								<input id="white_line-round_border" type="text" name="amount" value=<%= kakeiboInfo.getAmount()%>>
								<input id="white_line-round_border" type="text" name="memo" value=<%= kakeiboInfo.getMemo() %>>
								<button type="submit" name="comand" value="update" id="white_line-round_border">更新</button>
								<button type="submit" name="comand" value="delete" id="white_line-round_border">削除</button>
								<input type="hidden" name="kakeibo_id" value=<%= kakeiboInfo.getId() %>>
								<input type="hidden" name="money_type" value=<%= kakeiboInfo.getmoneyType() %>>
							</form>
						<% }%>
					<%} %>
						</section>
					<section class="details round_border-white_back wrapper">
					<% for(Kakeibo kakeiboInfo: kakeiboList){ %>
						<% if("支出".equals(kakeiboInfo.getmoneyType())) {%>
							<form class="edit_form" action="/MyKakeibo/HouseholdAccount" method="post">
								<input id="white_line-round_border" type="text" name="category" value=<%= kakeiboInfo.getCategory()%>>
								<input id="white_line-round_border" type="text" name="amount" value=<%= kakeiboInfo.getAmount()%>>
								<input id="white_line-round_border" type="text" name="memo" value=<%= kakeiboInfo.getMemo() %>>
								<button type="submit" name="comand" value="update" id="white_line-round_border">更新</button>
								<button type="submit" name="comand" value="delete" id="white_line-round_border">削除</button>
								<input type="hidden" name="kakeibo_id" value=<%= kakeiboInfo.getId() %>>
								<input type="hidden" name="money_type" value=<%= kakeiboInfo.getmoneyType() %>>
							</form>
						<%} %>
					<%} %>
					</section>
			</div>
		</div>
	</main>
</body>
</html>