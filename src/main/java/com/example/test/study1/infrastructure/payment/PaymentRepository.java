package com.example.test.study1.infrastructure.payment;

import com.example.test.study1.domain.payment.eneity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
