package start.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginpage","B & W 로그인");
		return "login";
		
	}
	
	@GetMapping("/recover_userinfo")
	public String move_recover_userinfo() {
		return "recover_userinfo";
	}
	
	@GetMapping("/recover_userinfo_splash")
	public String move_recover_userinfo_splash() {
		return "recover_userinfo_splash";
	}
	
	@GetMapping("/sign")
	public String sign() {
		return "sign";

	}
	@GetMapping("/user_info")
	public String user_info() {
		return "user_info";

	}
}
