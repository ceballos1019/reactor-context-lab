package co.com.bancolombia.consumer;

import co.com.bancolombia.model.moneytransfer.MoneyTransfer;
import co.com.bancolombia.model.moneytransfer.gateways.DepositGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Log
public class DepositFakeImpl implements DepositGateway {

    private final Random random = new Random();

    @Override
    public Mono<String> sendMoney(MoneyTransfer moneyTransfer) {
        return Mono.fromSupplier(() -> this.buildTransferRequest(moneyTransfer))
                .doOnNext(transferRequest -> {
                    log.info("======== Origin account: " + transferRequest.getOriginAccount());
                    log.info("======== Destination account: " + transferRequest.getDestinationAccount());
                    log.info("======== Amount: " + transferRequest.getAmount());
                    log.info("======== Transaction id: " + transferRequest.getTransactionId());
                })
                .thenReturn(String.valueOf(random.nextInt(1_000_000, 9_999_999)));
    }

    private TransferRequestDTO buildTransferRequest(MoneyTransfer moneyTransfer) {
        return TransferRequestDTO.builder()
                .originAccount(moneyTransfer.getOriginAccount())
                .destinationAccount(moneyTransfer.getDestinationAccount())
                .amount(moneyTransfer.getAmount())
                .transactionId("00000000000")
                .build();
    }
}
