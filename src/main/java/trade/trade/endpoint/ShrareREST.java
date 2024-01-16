package trade.trade.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trade.trade.dto.CustomerRequest;
import trade.trade.dto.ShareRequest;
import trade.trade.service.CustomerService;
import trade.trade.service.ShareService;

@RequestMapping("/share")
@RestController
public class ShrareREST
{
    @Autowired
    private ShareService shareService;

    @PostMapping("/saveShare")
    public ResponseEntity register( @RequestBody ShareRequest request) throws Exception {
        shareService.save(request);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
