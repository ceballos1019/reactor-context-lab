package co.com.bancolombia.model.moneytransfer.gateways;

import co.com.bancolombia.model.moneytransfer.MoneyTransfer;
import reactor.core.publisher.Mono;

public interface DepositGateway {

    Mono<String> sendMoney(MoneyTransfer moneyTransfer);

}
