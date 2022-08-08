package start.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import start.main.db.ShopVO;

public interface SDJShopRepository extends JpaRepository<ShopVO, Long>, ShopRepository {

}
