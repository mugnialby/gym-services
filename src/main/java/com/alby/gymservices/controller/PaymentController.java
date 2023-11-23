package com.alby.gymservices.controller;

import com.alby.gymservices.dto.request.payment.PaymentCheckRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.payment.PaymentCheckResponse;
import com.alby.gymservices.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping(
            name = "/check",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<PaymentCheckResponse>> check(PaymentCheckRequest request) {
        return paymentService.check(request);
    }

}
