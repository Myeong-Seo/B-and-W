package start.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	// 메인
	@GetMapping("/main")
	public String main() {
		return "main";
	}

	// 로그인
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginpage","B & W 로그인");
		return "login";
		
	}
	
	// 아이디 / 비밀번호 찾기
	@GetMapping("/recover_userinfo")
	public String move_recover_userinfo() {
		return "recover_userinfo";
	}
	
	// 아이디 / 비밀번호 찾기 후
	@GetMapping("/recover_userinfo_splash")
	public String move_recover_userinfo_splash() {
		return "recover_userinfo_splash";
	}
	
	// 회원가입
	@GetMapping("/sign")
	public String sign() {
		return "sign";

	}
	
	// 회원정보
	@GetMapping("/user_info")
	public String user_info() {
		return "user_info";

	}
	
	// 회원탈퇴
	@GetMapping("/user_out")
	public String user_out() {
		return "user_out";

	}
}
