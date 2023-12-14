package com.example.test.study1.presentation.dto;

import lombok.Data;

public class PaymentDto {

    @Data
    public static class Create {
        private Long userId;
        private String franchiseName;
        private Long paymentAmount;
        private String paymentStatus;
    }

    @Data
    public static class Update {
        private Long id;
        private String paymentStatus;
    }

}
