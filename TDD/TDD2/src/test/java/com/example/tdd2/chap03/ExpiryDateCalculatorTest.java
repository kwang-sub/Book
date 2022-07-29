package com.example.tdd2.chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ExpiryDateCalculatorTest {

    private void assertExpiryDate(PayDate payDate, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(payDate);
        assertEquals(expectedExpiryDate, expiryDate);
    }

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {


        LocalDate billingDate = LocalDate.of(2019, 3, 1);
        int payAmount = 10_000;
        LocalDate expectedExpiryDate = LocalDate.of(2019, 4, 1);

        PayDate payDate = PayDate.builder()
                .billingDate(billingDate)
                .payAmount(payAmount)
                .build();


        assertExpiryDate(payDate, expectedExpiryDate);

        LocalDate billingDate2 = LocalDate.of(2019, 5, 1);
        int payAmount2 = 10_000;
        LocalDate expectedExpiryDate2 = LocalDate.of(2019, 6, 1);

        PayDate payDate1 = PayDate.builder()
                .billingDate(billingDate2)
                .payAmount(payAmount2)
                .build();

        assertExpiryDate(payDate1, expectedExpiryDate2);
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {

        assertExpiryDate(PayDate.builder()
                .billingDate(LocalDate.of(2019, 1, 31))
                .payAmount(10000)
                .build(), LocalDate.of(2019, 2, 28));

        assertExpiryDate(PayDate.builder()
                .billingDate(LocalDate.of(2019, 5, 31))
                .payAmount(10000)
                .build(), LocalDate.of(2019, 6, 30));

        assertExpiryDate(PayDate.builder()
                .billingDate(LocalDate.of(2020, 1, 31))
                .payAmount(10000)
                .build(), LocalDate.of(2020, 2, 29));
    }


}
