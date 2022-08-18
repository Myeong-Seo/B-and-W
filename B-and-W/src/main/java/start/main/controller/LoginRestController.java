package start.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
		
		int result = us.recoverUserInfo(mail);
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
	//로그인 세션
	@PostMapping("/login_user")
	public String login(@RequestParam("uid") String uid, @RequestParam("upwd") String upwd, HttpServletRequest request) {
		return us.login(uid, upwd, request);
	}
	
	//회원정보변경 완료
	@PostMapping("/modify_user")
	public ResponseEntity<String> modify(HttpSession session, UserVO user) {
		if(us.userinfoo(session, user)) {
			session.invalidate();
			return ResponseEntity.ok("s");
		}
		else {
			return ResponseEntity.badRequest().body("f");
		}
	}
	
	//로그아웃 완료
	@GetMapping("/logout_user")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object id = session.getAttribute("id");
		session.invalidate();
		return (String)id + "님 로그아웃되었습니다.";
	}
	
	@GetMapping("/test")
	public List<UserVO> test() {
		return us.findAll();
	}
}
