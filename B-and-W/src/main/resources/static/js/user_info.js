window.onload = function() {
	document.getElementById("modify").addEventListener("click", function() {
		const password1 = document.getElementById("password1").value;
		const password2 = document.getElementById("password2").value;
		
		if ((password1.length > 0 && password1 != undefined) && (password2.length > 0 && password2 != undefined)) {
			if(password1.value == password2.value){
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
				return alert("회원정보 변경이 완료되었습니다. 다시 로그인 해주세요.");
			}
		} else {
			return alert("비밀번호가 틀립니다. 다시 입력해주세요.");
		}
	})
}
