package trade.trade.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int piece;
    private int io;

    @ManyToOne(fetch = FetchType.LAZY)
    private Share share;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo userInfo;
}
