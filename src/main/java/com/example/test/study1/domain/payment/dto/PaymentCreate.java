package com.example.test.study1.domain.payment.dto;

import com.example.test.study1.domain.payment.eneity.PaymentEntity;
import com.example.test.study1.presentation.dto.PaymentDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PaymentCreate {
    private final Long userId;
    private final String franchiseName;
    private final Long paymentAmount;
    private final String paymentStatus;

    @Builder
    public PaymentCreate(
            Long userId,
            String franchiseName,
            Long paymentAmount,
            String paymentStatus
    ) {
        this.userId = userId;
        this.franchiseName = franchiseName;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
    }

    public static PaymentCreate from(PaymentDto.Create create) {
        return PaymentCreate.builder()
                .userId(create.getUserId())
                .franchiseName(create.getFranchiseName())
                .paymentAmount(create.getPaymentAmount())
                .paymentStatus(create.getPaymentStatus())
                .build();
    }

    public PaymentEntity toPayment() {
        return PaymentEntity.builder()
                .userId(this.userId)
                .franchiseName(this.franchiseName)
                .paymentAmount(this.paymentAmount)
                .paymentStatus(this.paymentStatus)
                .build();
    }
}
