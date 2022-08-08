package start.main.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import start.main.db.UserVO;
import start.main.repository.UserRepository;

@Transactional
public class UserService {
	
	@Autowired
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
	
	public Optional<UserVO> findOne(String name) {
		return userRepository.findByuname(name);
	}
}
