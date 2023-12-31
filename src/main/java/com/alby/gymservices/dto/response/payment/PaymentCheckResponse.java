package com.alby.gymservices.dto.response.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentCheckResponse {

    private BigDecimal total;

    private PaymentStatusResponse paymentStatusResponse;
}
