package co.com.bancolombia.api.moneytransfer;

import co.com.bancolombia.model.moneytransfer.MoneyTransfer;
import co.com.bancolombia.usecase.transfermoney.TransferMoneyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class MoneyTransferHandler {

    private final TransferMoneyUseCase transferMoneyUseCase;

    public Mono<ServerResponse> sendMoney(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(MoneyTransfer.class)
                .flatMap(transferMoneyUseCase::sendMoney)
                .flatMap(voucher -> ServerResponse.ok().bodyValue(new MoneyTransferResponseDTO(voucher)));
    }
}