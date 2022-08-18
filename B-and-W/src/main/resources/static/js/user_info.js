window.onload = function() {
	document.getElementById("modify").addEventListener("click", function() {
		const uid = document.getElementById("uid").value;
		const upwd1 = document.getElementById("upwd1").value;
		const upwd2 = document.getElementById("upwd2").value;
		const uname = document.getElementById("uname").value;
		const uaddr1 = document.getElementById("uaddr1").value;
		const uaddr2 = document.getElementById("uaddr2").value;
		const uemail = document.getElementById("umail").value;
		const unumber = document.getElementById("unumber").value;
		
		const url = "/modify_user";
		let data = "uid=" + uid;
		data += "&uname=" + uname;
		data += "&uaddr1=" + uaddr1;
		data += "&uaddr2=" + uaddr2;
		data += "&umail=" + uemail;
		data += "&unumber=" + unumber; 
		if ((upwd1.length > 0 && upwd1 != undefined) && (upwd2.length > 0 && upwd2 != undefined)) {
			if(upwd1 == upwd2){
				data += "&upwd=" + upwd1;
				postAjax(url, data, function() {
					const res = this.response;
					if (res == "s") {
						alert("회원정보 변경이 완료되었습니다. 다시 로그인 해주세요.");
						location.href = "/main";
					}
					else if (res == "f"){
						alert("정보를 다시 확인해주세요.");
					}
				});
			}
			else{
				return alert("비밀번호가 틀립니다. 다시 입력해주세요.");	
			}
		}
		else {
			return alert("비밀번호를 입력해주세요.");
		}
	})
}
