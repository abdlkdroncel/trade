package trade.trade.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import trade.trade.dto.CustomerRequest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Share {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String code;
    private LocalDateTime createDate;
    private BigDecimal amount;

    @ManyToOne
    private Customer customer;

}
