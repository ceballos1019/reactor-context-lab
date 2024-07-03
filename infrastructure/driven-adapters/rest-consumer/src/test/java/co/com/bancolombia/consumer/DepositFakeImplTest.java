package co.com.bancolombia.consumer;

import co.com.bancolombia.model.moneytransfer.MoneyTransfer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class DepositFakeImplTest {

    private DepositFakeImpl depositFake;

    @BeforeEach
    void setUp() {
        depositFake = new DepositFakeImpl();
    }

    @Test
    void shouldSendMoneySuccessfully() {
        // Given
        MoneyTransfer moneyTransfer = MoneyTransfer.builder()
                .originAccount("123456789")
                .destinationAccount("987654321")
                .amount(1000D)
                .build();

        int expectedLength = 7;

        // When
        var transferResponse = depositFake.sendMoney(moneyTransfer);

        // Then
        StepVerifier.create(transferResponse)
                .expectNextMatches(voucher -> voucher.length() == expectedLength)
                .verifyComplete();
    }

}