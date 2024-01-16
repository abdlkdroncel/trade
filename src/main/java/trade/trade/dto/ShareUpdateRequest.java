package trade.trade.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShareUpdateRequest {

    private BigDecimal amount;
    private Long customerId;
    private Long shareId;
}
