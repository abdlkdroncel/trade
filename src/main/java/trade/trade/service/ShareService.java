package trade.trade.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trade.trade.dto.ShareRequest;
import trade.trade.entity.Customer;
import trade.trade.entity.Share;
import trade.trade.entity.ShareAmountHistory;
import trade.trade.repository.ShareRepository;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ShareService {

    @Autowired
    private ShareRepository shareRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ShareAmountHistoryService shareAmountHistoryService;

    public void save(ShareRequest request) throws Exception {

        if (request.getAmount().scale() > 2) throw new Exception("Decimal number is gt 2");
        if (request.getCode().length() > 3) throw new Exception("Share lentgh is gt 3");

        Customer customer = customerService.getCustomerById(request.getCustomerId());
        if (customer == null) throw new Exception("Customer not found");
        Share share = this.getShareByCode(request.getCode(), customer);

        if (share == null) {
            share = new Share();
            share.setAmount(request.getAmount());
            share.setCode(request.getCode());
            share.setCreateDate(LocalDateTime.now());
            share.setCustomer(customer);

        } else {
            ShareAmountHistory topByOrderByIdDesc = shareAmountHistoryService.findTopByOrderByIdDesc(share.getCustomer(), share);
            if (topByOrderByIdDesc != null) {
                Duration duration = Duration.between(topByOrderByIdDesc.getUpdateDate(), LocalDateTime.now());
                if (duration.toHours() < 1) {
                    throw new Exception("Update hour is lt 1 hour");
                }
            }
            share.setAmount(request.getAmount());
        }
        Share save = shareRepository.save(share);

        saveHistory(save);
    }

    public void saveHistory(Share share) {
        ShareAmountHistory topByOrderByIdDesc;
        topByOrderByIdDesc = new ShareAmountHistory();
        topByOrderByIdDesc.setCustomer(share.getCustomer());
        topByOrderByIdDesc.setShare(share);
        topByOrderByIdDesc.setAmount(share.getAmount());
        topByOrderByIdDesc.setUpdateDate(LocalDateTime.now());
        shareAmountHistoryService.save(topByOrderByIdDesc);
    }


    public Share getShareById(Long shareId) {
        return shareRepository.getShareById(shareId);
    }

    public Share getShareByCode(String code, Customer customer) {
        return shareRepository.getShareByCodeAndCustomerId(code, customer.getId());
    }
}
