package start.main.service;

import java.util.List;

import javax.transaction.Transactional;

import start.main.db.UserVO;
import start.main.repository.UserRepository;

@Transactional
public class UserService {
	
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void join_Member(UserVO member) {
		userRepository.save(member);
	}
	
	public List<UserVO> findAll() {
		return userRepository.findAll();
	}
	
}
