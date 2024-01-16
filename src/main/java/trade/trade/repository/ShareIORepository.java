package trade.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trade.trade.entity.ShareIO;

import java.util.List;

@Repository
public interface ShareIORepository extends JpaRepository<ShareIO,Long> {

    List<ShareIO> getShareIOByShareId(Long shareId);
}
