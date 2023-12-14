package com.example.test.study1.domain.payment.eneity;

import com.example.test.study1.domain.payment.dto.PaymentUpdate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name="payment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Long userId;            //사용자 ID
    private String franchiseName;   //결제 가맹점 명
    private Long paymentAmount;     //결제 요청 금액
    private String paymentStatus;   //결제 여부

    @Builder
    public PaymentEntity(
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

    public void update(PaymentUpdate update) {
        this.paymentStatus = update.getPaymentStatus();
    }
}
