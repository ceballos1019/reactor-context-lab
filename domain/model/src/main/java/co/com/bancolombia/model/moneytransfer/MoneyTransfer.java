package co.com.bancolombia.model.moneytransfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class MoneyTransfer {
    private String originAccount;
    private String destinationAccount;
    private Double amount;
}
