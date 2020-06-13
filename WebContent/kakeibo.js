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