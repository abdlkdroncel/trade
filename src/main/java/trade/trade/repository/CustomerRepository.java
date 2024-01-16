package trade.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trade.trade.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer getCustomerById(Long id);
    Customer getCustomerByName(String name);
}
