package start.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import start.main.db.ReserveVO;
import start.main.db.UserVO;

public interface SDJReserveRepository extends JpaRepository<ReserveVO, UserVO>, ReserveRepository {

	@Override
	Optional<ReserveVO> findByuid(Long sIndex);

	@Override
	Optional<ReserveVO> findBysname(String sName);
	
}
