package com.example.test.study1.domain.payment;

import com.example.test.study1.domain.payment.dto.PaymentCreate;
import com.example.test.study1.domain.payment.dto.PaymentInfo;
import com.example.test.study1.domain.payment.dto.PaymentUpdate;
import com.example.test.study1.domain.payment.eneity.PaymentEntity;
import com.example.test.study1.infrastructure.payment.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public List<PaymentInfo> findAll() {
        return paymentRepository.findAll()
                .stream()
                .map(PaymentInfo::from)
                .toList();
    }

    public PaymentInfo findById(Long id) {
        PaymentEntity paymentEntity = paymentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("결제 데이터가 존재하지 않습니다."));
        return PaymentInfo.from(paymentEntity);
    }

//    public void create(PaymentCreate create) {
//        paymentRepository.save(create.toPayment());
//    }

    @Transactional
    public PaymentInfo create(PaymentCreate create) {
        PaymentEntity paymentEntity = paymentRepository.save(create.toPayment());
        return PaymentInfo.from(paymentEntity);
    }

    @Transactional
    public PaymentInfo update(PaymentUpdate update) {
        PaymentEntity paymentEntity = paymentRepository.findById(update.getId())
                .orElseThrow(() -> new IllegalArgumentException("결제 데이터가 존재하지 않습니다."));
        paymentEntity.update(update);
        return PaymentInfo.from(paymentEntity);
    }

    @Transactional
    public void delete(Long id) {
        //paymentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("결제 데이터가 존재하지 않습니다."));
        paymentRepository.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        paymentRepository.deleteAll();
    }

}
