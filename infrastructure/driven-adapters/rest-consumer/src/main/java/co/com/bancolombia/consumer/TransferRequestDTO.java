package co.com.bancolombia.consumer;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class TransferRequestDTO {

    private final String originAccount;
    private final String destinationAccount;
    private final Double amount;
    private final String transactionId;

}
