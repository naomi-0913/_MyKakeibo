<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>家計簿入力</title>
<jsp:include page="/common.jsp" />
</head>
<body>
	<jsp:include page="/header.jsp" />
	<h2>家計簿入力</h2>
	<main>
		<div class="large_container">
		<form action="/MyKakeibo/HouseholdAccount" method="post" class="input_form">
			<div class="input_form-container1" id="round_border-white_back">
				<input type="checkbox" name="money_type" value="支出" id="outcome"><label for="outcome" id="white_line-round_border">支出</label>
				or
				<input type="checkbox" name="money_type" value="収入" id="income"><label for="income" id="white_line-round_border">収入</label>
				<input type="text" name="category" placeholder="項目" id="white_line-round_border">
				<input type="text" name="amount" placeholder="金額" id="white_line-round_border">
				<input type="text" name="memo" placeholder="メモ" id="white_line-round_border">
			</div>
			<div class="input_form-contanier2">
				<p id="round_border-white_back">収入合計:</p>
				<p id="round_border-white_back">支出合計:</p>
			</div>
			<div class="input_form-contanier3">
			<input type="submit" value="登録する" id="round_border-white_back">
			<input type="hidden" name="comand" value="insert">
			</div>
		</form>
		</div>
	</main>
</body>
</html>