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
	@GetMapping("/sign")
	public String sign() {
		return "sign";

	}
}
