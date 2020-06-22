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
							<p id="white_line-round_border"><%= kakeiboInfo.getCategory() %></p>
							<p id="white_line-round_border"><%= kakeiboInfo.getAmount() %></p>
							<p id="white_line-round_border"><%= kakeiboInfo.getMemo() %></p>
							<%
								BigDecimal amount = new BigDecimal(kakeiboInfo.getAmount());
								totalIncome = totalIncome.add(amount); %>
						<% }%>
					<%} %>
						</section>
					<section class="details round_border-white_back wrapper">
					<% for(Kakeibo kakeiboInfo: kakeiboList){ %>
						<% if("支出".equals(kakeiboInfo.getmoneyType())) {%>
							<p id="white_line-round_border"><%= kakeiboInfo.getCategory() %></p>
							<p id="white_line-round_border"><%= kakeiboInfo.getAmount() %></p>
							<p id="white_line-round_border"><%= kakeiboInfo.getMemo() %></p>
							<%
								BigDecimal amount = new BigDecimal(kakeiboInfo.getAmount());
								totalOutcome = totalOutcome.add(amount); %>
						<%} %>
					<%} %>
					</section>
				<section class="sub_total">
					<p class="white_font">収入合計: ¥</p><p class="sub_total-amount round_border-white_back"><%= totalIncome %></p>
				</section>
				<section class="sub_total">
					<p class="white_font">支出合計: ¥</p><p class="sub_total-amount round_border-white_back"><%= totalOutcome %></p>
				</section>
				<!-- あとで開発予定 -->
<!-- 				<section class="total wrapper">
				<p id="round_border-white_back">5月の収支: </p>
				</section> -->
			</div>
		</div>
	</main>
</body>
</html>