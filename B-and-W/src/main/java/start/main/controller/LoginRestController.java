package start.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
	public void recovery(@RequestParam("user_mail") String mail, HttpServletResponse response) {
		
		int result = us.revocerUserInfo(mail);
		if(result == 1) {
			String redirectUrl = "/recover_userinfo_splash";
			
			try {
				response.sendRedirect(redirectUrl);
			} catch (IOException e) {
				
				e.printStackTrace();
			}	
		}
		else {
			// 에러처리
		}
		
	}

	@GetMapping("/test")
	public List<UserVO> test() {
		return us.findAll();
	}
}
