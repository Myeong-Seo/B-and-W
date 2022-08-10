package start.main.repository;

import java.util.List;
import java.util.Optional;

import start.main.db.UserVO;

public interface UserRepository {
	UserVO save(UserVO member);
	Optional<UserVO> findByuid(String uid);
	Optional<UserVO> findByuname(String uname);
	Optional<UserVO> findByumail(String umail);
	List<UserVO> findAll();
	
}
