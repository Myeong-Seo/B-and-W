package start.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import start.main.db.UserVO;

public interface SDJpaUserRepository extends JpaRepository<UserVO, String>, UserRepository{
	
	@Override
	Optional<UserVO> findById(String u_id);
	
	@Override
	Optional<UserVO> findByName(String u_name);
	
}
