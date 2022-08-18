window.onload = function() {
	document.getElementById("login").addEventListener("click", function() {
		const uid = document.getElementById("uid").value;
		const upwd = document.getElementById("upwd").value;

		//console.log(id);
		if (uid.length > 0 && uid != undefined) {
			if (upwd.length > 0 && upwd != undefined) {
				
				const url = "/login_user";
				const data = "uid=" + uid; 
				data += "&upwd=" + upwd;
				postAjax(url, data, function() {
					if (this.response == "s") {
						alert(uid + "로그인에 성공하셨습니다");
						location.href = "/main";
					}
					else if (this.response == "f") {
						alert("아이디 또는 비밀번호가 틀렸습니다");
					}
					else {
						alert("아이디가 존재하지 않습니다");
					}
				});
			}
		}
	})
}

function logout(){
	getAjax("/logout_user", function(){
		alert(this.response);
		location.href = "/main";
	})
}
