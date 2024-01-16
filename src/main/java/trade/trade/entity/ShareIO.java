package trade.trade.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShareIO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int piece;
    private int io;

    @ManyToOne
    private Share share;
}
