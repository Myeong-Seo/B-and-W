package start.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import start.main.db.UserVO;
import start.main.repository.SDJpaUserRepository;

@AllArgsConstructor
@Service
public class UserService {
	
	private SDJpaUserRepository userRepository;

	public void join_Member(UserVO member) {
		userRepository.save(member);
	}
	
	public List<UserVO> findAll() {
		return userRepository.findAll();
	}
	
}
