package trade.trade.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trade.trade.dto.CustomerRequest;
import trade.trade.entity.Customer;
import trade.trade.service.CustomerService;

@RequestMapping("/customer")
@RestController
public class CustomerREST {

    @Autowired private CustomerService customerService;

    @PostMapping("/saveCustomer")
    public ResponseEntity register(
            @RequestBody CustomerRequest request
    ) throws Exception {
        customerService.save(request);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }


}
