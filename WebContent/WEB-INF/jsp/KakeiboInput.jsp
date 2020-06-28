<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<title>家計簿入力</title>
<jsp:include page="/common.jsp" />
<script type="text/javascript">
function removeIncomeChecked() {
	checkbox = document.getElementById('income');
	if (checkbox.checked) {
		checkbox.checked = false;
	}
}
function removeOutcomeChecked() {
	checkbox = document.getElementById('outcome');
	if (checkbox.checked) {
		checkbox.checked = false;
	}
}
</script>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<% if (msg != null) { %>
		<h4><%= msg %></h4>
	<% } %>
	<h2>家計簿入力</h2>
	<main>
		<div class="large_container">
		<form action="/MyKakeibo/HouseholdAccount" method="post" class="input_form" name="kakeibo_form" onsubmit="return checkKakeiboForm();">
			<div class="input_form-container1 round_border-white_back">
				<input type="checkbox" name="money_type" value="支出" id="outcome" onclick="removeIncomeChecked();"><label for="outcome" id="white_line-round_border">支出</label>
				or
				<input type="checkbox" name="money_type" value="収入" id="income" onclick="removeOutcomeChecked();"><label for="income" id="white_line-round_border">収入</label>
				<input type="text" name="category" placeholder="項目" id="white_line-round_borde">
				<input type="text" name="amount" placeholder="金額" id="white_line-round_border">
				<input type="text" name="memo" placeholder="メモ" id="white_line-round_border">
			</div>
			<!-- あとで開発予定 -->
<!-- 			<div class="input_form-contanier2">
				<p class="white_font">収入合計: </p><p class="sub_total-amount" id="round_border-white_back"></p>
				<p class="white_font">支出合計: </p><p class="sub_total-amount" id="round_border-white_back"></p>
			</div> -->
			<div class="input_form-contanier3">
			<input class="round_border-white_back" type="submit" value="登録する">
			<input type="hidden" name="comand" value="insert">
			</div>
		</form>
		</div>
	</main>
</body>
</html>