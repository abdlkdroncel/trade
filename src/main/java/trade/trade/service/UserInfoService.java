package trade.trade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trade.trade.dto.UserInfoRequest;
import trade.trade.entity.UserInfo;
import trade.trade.repository.UserInfoRepository;

@Service
public class UserInfoService {

    @Autowired private UserInfoRepository userInfoRepository;

    public void save(UserInfoRequest request) {
        UserInfo info = getUserInfoByUserName(request.getUserName());
        if(info==null) info=new UserInfo();
        info.setUserName(request.getUserName());
        userInfoRepository.save(info);
    }

    public UserInfo getUserInfoByUserName(String userName){
        return userInfoRepository.getUserInfoByUserName(userName);
    }

    public UserInfo getUserInfoById(Long id){
        return userInfoRepository.getUserInfoById(id);
    }
}
