package trade.trade.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trade.trade.dto.ShareIORequest;
import trade.trade.dto.ShareRequest;
import trade.trade.service.ShareIOService;
import trade.trade.service.ShareService;

@RequestMapping("/shareIO")
@RestController
public class ShareIOREST {

    @Autowired
    private ShareIOService shareIoService;

    @PostMapping("/saveShareIO")
    public ResponseEntity register(@RequestBody ShareIORequest request) throws Exception {
        shareIoService.save(request);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
