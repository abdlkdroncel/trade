package trade.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trade.trade.entity.Share;

@Repository
public interface ShareRepository extends JpaRepository<Share,Long> {

    Share getShareById(Long id);
    Share getShareByCodeAndCustomerId(String code,Long customerId);
}
