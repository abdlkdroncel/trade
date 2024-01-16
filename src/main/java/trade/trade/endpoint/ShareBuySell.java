package trade.trade.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trade.trade.dto.UserInfoRequest;
import trade.trade.dto.UserWalletRequest;
import trade.trade.service.UserWalletService;

@RequestMapping("/shareBuySel")
@RestController
public class ShareBuySell {

    @Autowired private UserWalletService userWalletService;

    @PostMapping("/buy")
    public ResponseEntity buy(@RequestBody UserWalletRequest request) throws Exception {
        userWalletService.buy(request);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @PostMapping("/sell")
    public ResponseEntity sell(@RequestBody UserWalletRequest request) throws Exception {
        userWalletService.sell(request);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
