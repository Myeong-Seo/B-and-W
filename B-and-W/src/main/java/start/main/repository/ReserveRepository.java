package start.main.repository;

import java.util.List;
import java.util.Optional;

import start.main.db.ReserveVO;

public interface ReserveRepository {
	ReserveVO save(ReserveVO reserve);
	Optional<ReserveVO> findByuid(Long sIndex);
	Optional<ReserveVO> findBysname(String sName);
	List<ReserveVO> findAll();

}
