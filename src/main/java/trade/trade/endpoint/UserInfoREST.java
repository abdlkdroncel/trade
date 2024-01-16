package trade.trade.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trade.trade.dto.ShareRequest;
import trade.trade.dto.UserInfoRequest;
import trade.trade.entity.UserInfo;
import trade.trade.service.UserInfoService;

@RequestMapping("/userInfo")
@RestController
public class UserInfoREST {

    @Autowired private UserInfoService userInfoService;

    @PostMapping("/saveUser")
    public ResponseEntity register(@RequestBody UserInfoRequest request) throws Exception {
        userInfoService.save(request);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
