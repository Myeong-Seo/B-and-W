package start.main.repository;

import start.main.db.UserVO;

import java.util.List;
import java.util.Optional;


public interface UserRepository {
	UserVO save(UserVO member);
	Optional<UserVO> findByuid(String uId);
	Optional<UserVO> findByuname(String uName);
	List<UserVO> findAll();
	
}
