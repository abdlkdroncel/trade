package trade.trade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trade.trade.dto.ShareUpdateRequest;
import trade.trade.entity.Customer;
import trade.trade.entity.Share;
import trade.trade.entity.ShareAmountHistory;
import trade.trade.repository.ShareAmountHistoryRepository;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ShareAmountHistoryService {

    @Autowired private ShareAmountHistoryRepository shareAmountHistoryRepository;
    @Autowired private ShareService shareService;
    @Autowired private CustomerService customerService;

    public ShareAmountHistory findTopByOrderByIdDesc(Customer customer,Share share){
        return shareAmountHistoryRepository.findTopByOrderByIdDesc(customer.getId(),share.getId());
    }

    public void save(ShareAmountHistory shareAmountHistory){
        shareAmountHistoryRepository.save(shareAmountHistory);
    }

    public void update(ShareUpdateRequest request) throws Exception {
        Share share = shareService.getShareById(request.getShareId());
        if(share==null) throw new Exception("Share not found");
        Customer customer=customerService.getCustomerById(request.getCustomerId());
        if(customer==null) throw new Exception("Customer not found");

        ShareAmountHistory amountHistory = this.findTopByOrderByIdDesc(customer, share);
        if(amountHistory!=null){
            Duration duration=Duration.between(LocalDateTime.now(),amountHistory.getUpdateDate());
            if(duration.toHoursPart()>1) throw new Exception("Update time is lt 1 hour");
            saveShareAmountHistory(request, share, customer);
        }else{
            saveShareAmountHistory(request, share, customer);
        }

    }

    private void saveShareAmountHistory(ShareUpdateRequest request, Share share, Customer customer) {
        ShareAmountHistory shareAmountHistory=new ShareAmountHistory();
        shareAmountHistory.setAmount(request.getAmount());
        shareAmountHistory.setShare(share);
        shareAmountHistory.setCustomer(customer);
        shareAmountHistoryRepository.save(shareAmountHistory);
    }
}
