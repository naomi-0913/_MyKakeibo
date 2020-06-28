window.onload = function() {
	function hamburger() {
		document.getElementById('nav_f').classList.toggle('fadein');
	}

	document.getElementById('target').addEventListener('click', function () {
		hamburger();
	});

	let list = document.getElementsByClassName('list');

	for (let i = 0; i < list.length; i++) {
		list[i].addEventListener('click', function () {
			hamburger();
	    });
	}

	function hamburger2() {
		document.getElementById('nav_f2').classList.toggle('fadein');
	}

	document.getElementById('target2').addEventListener('click', function () {
		hamburger2();
	});

	let list2 = document.getElementsByClassName('list2');

	for (let i = 0; i < list2.length; i++) {
		list2[i].addEventListener('click', function () {
			hamburger2();
	    });
	}


}

function checkInformation() {
	user_name = document.forms.user_form.user_name.value;
	password = document.forms.user_form.password.value;
	if (!user_name || !password) {
		alert("未入力の項目があります。");
		return false;
	}
}
function checkKakeiboForm() {
	income = document.getElementById('income');
	outcome = document.getElementById('outcome');
	if(!income.checked && !outcome.checked) {
		alert("支出また収入を選択して下さい。");
		return false;
	}
	amount = document.forms.kakeibo_form.amount.value;
	if (!amount) {
		alert("金額は必須入力です。");
		return false;
	} else if (!isNumber(amount)) {
		alert("金額は数字で入力して下さい。");
		return false;
	}
}
function isNumber(val){
	  var regex = new RegExp(/^[0-9]+$/);
	  return regex.test(val);
}




