package com.alby.gymservices.serviceimpl;

import com.alby.gymservices.dto.request.payment.PaymentCheckRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.member.MemberCheckValidityResponse;
import com.alby.gymservices.dto.response.payment.PaymentCheckResponse;
import com.alby.gymservices.entity.member.Member;
import com.alby.gymservices.entity.payment.Payment;
import com.alby.gymservices.repository.PaymentRepository;
import com.alby.gymservices.service.PaymentService;
import com.alby.gymservices.service.ValidationService;
import com.alby.gymservices.util.Constant;
import com.alby.gymservices.util.MemberUtil;
import com.alby.gymservices.util.PaymentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    private final ValidationService validationService;

    @Override
    public WebResponse<List<PaymentCheckResponse>> check(PaymentCheckRequest request) {
        validationService.validate(request);

        List<Payment> paymentsFromDb = paymentRepository.findByMemberIdAndPaymentStatusIdIn(request.getMemberId(),
                Arrays.asList(Constant.PAYMENT_STATUS.OUTSTANDING_ID,
                        Constant.PAYMENT_STATUS.PROCESSED_ID));

        if (null == paymentsFromDb)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        List<PaymentCheckResponse> paymentCheckResponses = new ArrayList<>();
        for (Payment payment: paymentsFromDb) {
            paymentCheckResponses.add(PaymentUtil.mapPaymentToPaymentCheckResponse(payment));
        }

        return WebResponse.<List<PaymentCheckResponse>> builder()
                .data(paymentCheckResponses)
                .message("OK")
                .build();
    }
}
