package com.example.test.study1.domain.payment.dto;

import com.example.test.study1.domain.payment.eneity.PaymentEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentInfo {
    private Long id;
    private Long userId;
    private String franchiseName;
    private Long paymentAmount;
    private String paymentStatus;

    @Builder
    public PaymentInfo(
            Long id,
            Long userId,
            String franchiseName,
            Long paymentAmount,
            String paymentStatus
    ) {
        this.id = id;
        this.userId = userId;
        this.franchiseName = franchiseName;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
    }

    public static PaymentInfo from(PaymentEntity paymentEntity) {
        return PaymentInfo.builder()
                .id(paymentEntity.getId())
                .userId(paymentEntity.getUserId())
                .franchiseName(paymentEntity.getFranchiseName())
                .paymentAmount(paymentEntity.getPaymentAmount())
                .paymentStatus(paymentEntity.getPaymentStatus())
                .build();
    }

}
