package com.example.test.study1.domain.payment.dto;

import com.example.test.study1.presentation.dto.PaymentDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PaymentUpdate {
    private Long id;
    private String paymentStatus;

    @Builder
    public PaymentUpdate(Long id, String paymentStatus) {
        this.id = id;
        this.paymentStatus = paymentStatus;
    }

    public static PaymentUpdate from(PaymentDto.Update update) {
        return PaymentUpdate.builder()
                .id(update.getId())
                .paymentStatus(update.getPaymentStatus())
                .build();
    }
}
