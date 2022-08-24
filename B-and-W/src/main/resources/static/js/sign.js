// 가입 부분
window.onload = function () {
    document.getElementById("btn").addEventListener("click", function () {
        // 가입할 데이터들을 불러오기
        const uid = document.getElementById("uid").value
        const upwd = document.getElementById("upwd").value
        const uname = document.getElementById("uname").value
        const uaddr1 = document.getElementById("uaddr1").value
        const uaddr2 = document.getElementById("uaddr2").value
        const first = document.getElementById("domain-first").value
        const second = document.getElementById("domain-second").value
        const middle = document.getElementById("middle").value
        const umail = document.getElementById("umail").value
        const unumber = document.getElementById("unumber").value
        var regPhone = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;


        // 작성된
        if (uid.length > 3 && uid != undefined) {
            if (document.getElementById("idChkFlag").value != 0) {
                if (upwd.length > 3 && upwd != undefined) {
                    if (upwd == document.getElementById("upwdCheck").value) {
                        if (uname.length > 0 && uname != undefined) {
                            if (first != "" && second != "") {
                                if (regPhone.test(unumber) === true) {
                                    const url = "/ch/users/sign";
                                    let data = "uid= " + uid;
                                    data += "&upwd= " + upwd;
                                    data += "&uname= " + uname;
                                    data += "&uaddr1= " + uaddr1;
                                    data += "&uaddr2= " + uaddr2;
                                    data += "&umail= " + umail.val(first + middle + second);
                                    data += "&unumber= " + unumber;
                                    postAjax(url, data, function () {
                                        const res = this.response;
                                        if (res == 's') {
                                            alert("가입이 완료");
                                            location.href = "/main";
                                        }
                                    });
                                } else {
                                    document.getElementById("unumber").focus();
                                    alert("전화번호를 입력해주세요.");
                                }
                            } else {
                                document.getElementById("domain-first").focus();
                                alert("이메일을 입력해주세요.")
                            }
                        } else {
                            document.getElementById("umail").focus();
                            alert("이름을 입력해주세요.")
                        }
                    } else {
                        document.getElementById("upwdCheck").focus();
                        alert("비밀번호를 다시 한 번 확인해주세요.")
                    }
                } else {
                    document.getElementById("upwd").focus();
                    alert("비밀번호 입력을 올바르게 해주세요.");
                }
            } else {
                document.getElementById("uid").focus();
                alert("아이디 중복체크를 해주세요.");
            }
        } else {
            document.getElementById("uid").focus();
            alert("아이디를 확인해주세요.");
        }


    });

    document.getElementById("idCheck").addEventListener("click", function () {
        const uid = document.getElementById("uid");
        if (uid.value.length > 3 && uid.value != undefined) {
            const url = "/ch/users/" + uid.value;
            getAjax(url, function () {
                const res = this.response;
                if (res == "s") {
                    document.getElementById("idChkFlag").value = 1;
                    alert("사용 가능한 아이디");
                } else if (res == "f") {
                    document.getElementById("idChkFlag").value = 0;
                    alert("이미 존재하는 아이디");
                } else if (res == "x") {
                    document.getElementById("idChkFlag").value = 0;
                    alert("계정 조회 실패");
                }
            });
        } else {
            uid.focus();
            return alert("아이디를 입력")
        }
    })
    /*       document.getElementById("sign_up").addEventListener('click', () => {
                const upwd = document.getElementById("upwd");
                const upwdCheck = document.getElementById("upwdCheck");
                const join_form = document.getElementById("join_form").value

                if (upwd.value == upwdCheck.value) {         // 두개의 비번이 같다면
                    join_form.submit();            // join_form(button) 을 submit()해라
                } else {
                    alert('패스워드가 일치하지 않습니다.')
                    upwd.value = '';             // 빈값으로 만들기
                    upwdCheck.value = '';             // 빈값으로 만들기
                    upwd.focus();            //커서 이동
                }
            });*/

    const domainListEl = document.querySelector('#domain-list')
    const domainInputEl = document.querySelector('#domain-second')
// select 옵션 변경 시
    domainListEl.addEventListener('change', (event) => {
        // option에 있는 도메인 선택 시
        if (event.target.value !== "type") {
            // 선택한 도메인을 input에 입력하고 disabled
            domainInputEl.value = event.target.value
            domainInputEl.disabled = true
        } else { // 직접 입력 시
            // input 내용 초기화 & 입력 가능하도록 변경
            domainInputEl.value = ""
            domainInputEl.disabled = false
        }
    })
}

/*    document.getElementById("upwd2").addEventListener("keyup", function () {
        const pw1 = document.getElementById("upwd").value;
        const pwChk = document.getElementById("pwChk");
        if (pw1 == this.value) {
            pwChk.style.display = "none";
        } else {
            pwChk.innerText = "비밀번호가 같지 않습니다.";
            pwChk.style.display = "block";
        }
    })*/

// 도메인 직접 입력 or domain option 선택


function adr() {
    document.getElementById("uaddr1").addEventListener("click", function () { //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function (data) { //선택시 입력값 세팅
                document.getElementById("uaddr1").value = data.address; // 주소 넣기
                document.querySelector("input[name=uaddr2]").focus(); //상세입력 포커싱
            }
        }).open();//끄는방법 추가해서
    });
}

