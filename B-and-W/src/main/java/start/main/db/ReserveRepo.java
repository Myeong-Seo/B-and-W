package start.main.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepo extends JpaRepository<ReserveVO, UserVO> {

}
