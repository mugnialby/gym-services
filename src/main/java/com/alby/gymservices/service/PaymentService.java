package com.alby.gymservices.service;

import com.alby.gymservices.dto.request.payment.PaymentCheckRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.payment.PaymentCheckResponse;

import java.util.List;

public interface PaymentService {

    WebResponse<List<PaymentCheckResponse>> check(PaymentCheckRequest request);
}
