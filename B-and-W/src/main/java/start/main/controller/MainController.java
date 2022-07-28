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
	
	@GetMapping("/recoverUserInfo")
	public String move_recoverUserInfo() {
		return "recoverUserInfo";
	}
}
