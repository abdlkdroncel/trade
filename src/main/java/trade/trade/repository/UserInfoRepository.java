package trade.trade.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trade.trade.entity.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

    UserInfo getUserInfoByUserName(String user);
    UserInfo getUserInfoById(Long id);
}
