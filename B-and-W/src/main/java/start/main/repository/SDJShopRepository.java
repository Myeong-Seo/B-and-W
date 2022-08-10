package start.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import start.main.db.ShopVO;
import start.main.db.UserVO;

import java.util.Optional;

public interface SDJShopRepository extends JpaRepository<ShopVO, Long>, ShopRepository {

    @Override
    Optional<ShopVO> findBysindex(Long sindex);
    
}
