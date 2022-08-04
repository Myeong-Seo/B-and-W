package start.main.repository;

import java.util.List;
import java.util.Optional;

import start.main.db.ReserveVO;
import start.main.db.ShopVO;
import start.main.db.UserVO;

public interface ReserveRepository {
	ReserveVO save(ReserveVO reserve);
	Optional<ReserveVO> findByuId(Long sIndex);
	Optional<ReserveVO> findBysName(String sName);
	List<ReserveVO> findAll();

}
