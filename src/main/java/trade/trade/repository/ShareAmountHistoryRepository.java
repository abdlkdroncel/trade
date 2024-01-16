package trade.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import trade.trade.entity.Share;
import trade.trade.entity.ShareAmountHistory;

@Repository
public interface ShareAmountHistoryRepository extends JpaRepository<ShareAmountHistory,Long> {

    @Query("from ShareAmountHistory  e where e.customer.id=:customerId and e.share.id=:shareId order by id DESC limit 1")
    ShareAmountHistory findTopByOrderByIdDesc(Long customerId,Long shareId);
}
