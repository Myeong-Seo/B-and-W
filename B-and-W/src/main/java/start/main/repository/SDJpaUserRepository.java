package start.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import start.main.db.UserVO;

@Repository
public interface SDJpaUserRepository extends JpaRepository<UserVO, String>{
	
}
