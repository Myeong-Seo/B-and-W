package start.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import start.main.db.UserVO;
import start.main.service.UserService;

@RestController
public class LoginRestController {
	
	private final UserService us;
	
	@Autowired
	public LoginRestController(UserService us) {
		this.us = us;
	}
	
	@PostMapping("/recover_user")
	public String recovery(@RequestParam("user_mail") String mail) {
		int result = us.recoverUserInfo(mail);
		
		return "redirect:/";
	}

	@GetMapping("/test")
	public List<UserVO> test() {
		return us.findAll();
	}
}
