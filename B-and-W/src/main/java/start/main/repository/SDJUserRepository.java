package start.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import start.main.db.UserVO;

public interface SDJUserRepository extends JpaRepository<UserVO, String>, UserRepository{
	
	@Override
	Optional<UserVO> findByuid(String uId);
	
	@Override
	Optional<UserVO> findByuname(String uName);
	
}
