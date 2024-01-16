package trade.trade.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trade.trade.dto.ShareRequest;
import trade.trade.dto.ShareUpdateRequest;
import trade.trade.service.ShareAmountHistoryService;

@RequestMapping("/shareAmountHistory")
@RestController
public class ShareAmountHistoryREST {

    @Autowired private ShareAmountHistoryService shareAmountHistoryService;

    @PostMapping("/saveShare")
    public ResponseEntity register(
            @RequestBody ShareUpdateRequest request
    ) throws Exception {
        shareAmountHistoryService.update(request);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
