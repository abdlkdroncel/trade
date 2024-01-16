package trade.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trade.trade.entity.UserWallet;

import java.util.List;

@Repository
public interface UserWalletRepository extends JpaRepository<UserWallet,Long> {

    UserWallet getUserWalletByUserInfoId(Long userId);
    List<UserWallet> getUserWalletsByUserInfoIdAndShareId(Long userId,Long shareId);
}
