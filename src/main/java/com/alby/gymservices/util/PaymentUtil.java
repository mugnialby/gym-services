package com.alby.gymservices.util;

import com.alby.gymservices.dto.response.payment.PaymentCheckResponse;
import com.alby.gymservices.dto.response.payment.PaymentStatusResponse;
import com.alby.gymservices.entity.payment.Payment;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class PaymentUtil {

    public static PaymentCheckResponse mapPaymentToPaymentCheckResponse(Payment request) {
        return PaymentCheckResponse.builder()
                .total(request.getTotal())
                .paymentStatusResponse(mapPaymentStatusToPaymentStatusResponse(request.getPaymentStatus()))
                .build();
    }

    public static PaymentStatusResponse mapPaymentStatusToPaymentStatusResponse(PaymentStatus request) {
        return PaymentStatusResponse.builder()
                .paymentStatusName(request.getName())
                .build();
    }
}
