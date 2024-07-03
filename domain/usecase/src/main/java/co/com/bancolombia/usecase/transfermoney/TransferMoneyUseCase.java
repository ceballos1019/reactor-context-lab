package co.com.bancolombia.usecase.transfermoney;

import co.com.bancolombia.model.moneytransfer.MoneyTransfer;
import co.com.bancolombia.model.moneytransfer.gateways.DepositGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Log
public class TransferMoneyUseCase {

    private final DepositGateway depositGateway;

    public Mono<String> sendMoney(MoneyTransfer moneyTransfer) {
        return depositGateway.sendMoney(moneyTransfer)
                .doOnNext(voucher -> log.info("Transfer completed: " + voucher));
    }

}
