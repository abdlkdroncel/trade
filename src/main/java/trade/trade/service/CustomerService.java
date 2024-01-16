package trade.trade.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trade.trade.dto.CustomerRequest;
import trade.trade.entity.Customer;
import trade.trade.entity.Share;
import trade.trade.entity.ShareAmountHistory;
import trade.trade.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired  private CustomerRepository repository;
    @Autowired  private ShareAmountHistoryService shareAmountHistoryService;
    @Autowired  private ShareService shareService;

    public void save(CustomerRequest request) throws Exception {
        Customer customer = repository.getCustomerByName(request.getName());
        if(customer==null) customer=new Customer();
        customer.setName(request.getName());
        Customer save = repository.save(customer);

    }

    public Customer getCustomerById(Long customerId){
        return repository.getCustomerById(customerId);
    }
}
