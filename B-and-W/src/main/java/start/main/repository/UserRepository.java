package start.main.repository;

import java.util.List;
import java.util.Optional;

import start.main.db.UserVO;

public interface UserRepository {
	UserVO join(UserVO member);
	Optional<UserVO> findById(String u_id);
	Optional<UserVO> findByName(String u_name);
	List<UserVO> findAll();
	
}
