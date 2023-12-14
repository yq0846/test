package com.example.test.study1.application;

import com.example.test.study1.domain.payment.PaymentService;
import com.example.test.study1.domain.payment.dto.PaymentInfo;
import com.example.test.study1.domain.payment.dto.PaymentUpdate;
import com.example.test.study1.domain.user.UserService;
import com.example.test.study1.presentation.dto.PaymentDto;
import com.example.test.study1.presentation.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
@RequiredArgsConstructor
public class UserPaymentUseCase {
    private final PaymentService paymentService;
    private final UserService userService;

    public void calculate(Long paymentId, Long UserId) {
        PaymentInfo paymentInfo = paymentService.findById(paymentId);
        UserDto userInfo = userService.findById(UserId);

        //이미 결제가 완료된 요청 재결제 시
        if(paymentInfo.getPaymentStatus().equals("Y")) {
            throw new RuntimeException("이미 결제가 완료된 건입니다.");
        }

        //결제 요청 금액 > 보유 금액
        if(paymentInfo.getPaymentAmount() > userInfo.getAvailableAmount()) {
            throw new RuntimeException("잔액이 부족합니다.");
        } else {
            userInfo.setAvailableAmount(userInfo.getAvailableAmount() - paymentInfo.getPaymentAmount());
            userService.update(userInfo);

            PaymentDto.Update paymentUpdate = new PaymentDto.Update();
            paymentUpdate.setId(paymentInfo.getId());
            paymentUpdate.setPaymentStatus("Y");
            paymentService.update(PaymentUpdate.from(paymentUpdate));
        }
    }
}
