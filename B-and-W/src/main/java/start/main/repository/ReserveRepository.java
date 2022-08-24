package start.main.repository;
import java.util.List;
import java.util.Optional;
import start.main.db.ReserveVO;

public interface ReserveRepository {

//	ReserveVO save(ReserveVO reserve);
	Optional<ReserveVO> findBysindex(Long sindex);
	Optional<ReserveVO> findBysname(String sname);
	List<ReserveVO> findAll();

}