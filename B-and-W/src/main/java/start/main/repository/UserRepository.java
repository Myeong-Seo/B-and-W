package start.main.repository;

import java.util.List;
import java.util.Optional;

import start.main.db.UserVO;

public interface UserRepository {
	UserVO save(UserVO member);
	Optional<UserVO> findByuId(String uId);
	Optional<UserVO> findByuName(String uName);
	List<UserVO> findAll();
	
}
