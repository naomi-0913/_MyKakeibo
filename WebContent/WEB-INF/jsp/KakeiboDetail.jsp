<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>家計簿</title>
<jsp:include page="/common.jsp" />
</head>
<body>
	<jsp:include page="/header.jsp" />
	<div class="title_wrapper ">
		<h3>5月の収入</h3>
		<h3>5月の支出</h3>
	</div>
	<main>
		<div class="large_container">
			<div class="wrapper">
				<section class="details round_border-white_back wrapper">
					<p id="white_line-round_border">項目</p>
					<p id="white_line-round_border">金額</p>
					<p id="white_line-round_border">メモ</p>
				</section>
				<section class="details round_border-white_back wrapper">
					<p id="white_line-round_border">項目</p>
					<p id="white_line-round_border">金額</p>
					<p id="white_line-round_border">メモ</p>
				</section>
				<section class="sub_total">
					<p class="round_border-white_back">収入合計: </p>
				</section>
				<section class="sub_total">
					<p class="round_border-white_back">支出合計: </p>
				</section>
				<section class="total wrapper">
				<p id="round_border-white_back">5月の収支: </p>
				</section>
			</div>
		</div>
	</main>
</body>
</html>