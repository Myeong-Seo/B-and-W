window.onload = function() {
	document.getElementById("login").addEventListener("click", function() {
		const id = document.getElementById("id").value;
		const password = document.getElementById("password").value;

		console.log(id);


		if (id.length > 0 && id != undefined) {
			if (password.length > 0 && password != undefined) {
				/*
				const url = "/ch/users/user/" + uid;
				const data = "upw=" + upw;
				postAjax(url, data, function() {
					if (this.response == "s") {
						alert("로그인에 성공하셨습니다");
						location.href = "/ch";
					} else if (this.response == "f") {
						alert("아이디, 혹은 비밀번호가 틀렸습니다");
					} else {
						alert("해당 아이디가 존재하지 않습니다");
					}
				});
				*/
				return alert(id+"님 환영합니다.");
			} else {
				return alert("비밀번호 입력을 확인해주세요");
			}
		} else {
			return alert("아이디 입력을 확인해주세요");
		}
	})
}
