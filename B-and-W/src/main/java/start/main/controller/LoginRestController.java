package start.main.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import start.main.db.UserVO;
import start.main.service.UserService;

@RestController
@AllArgsConstructor
public class LoginRestController {
	
	private final UserService us;
	
	@GetMapping("/test")
	public List<UserVO> test() {
		return us.findAll();
	}
}
