package com.example.test.study1.presentation.api;

import com.example.test.study1.domain.payment.PaymentService;
import com.example.test.study1.domain.payment.dto.PaymentCreate;
import com.example.test.study1.domain.payment.dto.PaymentInfo;
import com.example.test.study1.domain.payment.dto.PaymentUpdate;
import com.example.test.study1.presentation.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentRestController {

    private final PaymentService paymentService;

    //전체 조회
    @GetMapping("/getAll")
    public ResponseEntity<List<PaymentInfo>> getAllpayments() {
        List<PaymentInfo> paymentList = paymentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(paymentList);
    }

    //ID로 조회
    @GetMapping("/get/{key}")
    public ResponseEntity<PaymentInfo> getPayment(@PathVariable("key") Long id) {
        PaymentInfo payment = paymentService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }

    //생성
    @PostMapping("/post")
    public ResponseEntity<PaymentInfo> createPayment(@RequestBody PaymentDto.Create create) {
        PaymentInfo payment = paymentService.create(PaymentCreate.from(create));
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }

    //수정
    @PutMapping("/put")
    public ResponseEntity<PaymentInfo> updatePayment(@RequestBody PaymentDto.Update update) {
        PaymentInfo payment = paymentService.update(PaymentUpdate.from(update));
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }

    //ID로 삭제
    @DeleteMapping("/delete/{key}")
    public ResponseEntity<Void> deletePayment(@PathVariable("key") Long id) {
        paymentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //전체 삭제
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllpayment() {
        paymentService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
