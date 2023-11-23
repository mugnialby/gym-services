package com.alby.gymservices.serviceimpl;

import com.alby.gymservices.dto.request.subscription.SubscribeCancelRequest;
import com.alby.gymservices.dto.request.subscription.SubscribeExtendRequest;
import com.alby.gymservices.dto.request.subscription.SubscribeRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.programs.ProgramResponse;
import com.alby.gymservices.entity.program.Program;
import com.alby.gymservices.entity.subscription.Subscription;
import com.alby.gymservices.entity.subscription.SubscriptionStatus;
import com.alby.gymservices.repository.SubscriptionRepository;
import com.alby.gymservices.service.SubscriptionService;
import com.alby.gymservices.service.ValidationService;
import com.alby.gymservices.util.Constant;
import com.alby.gymservices.util.ProgramUtil;
import com.alby.gymservices.util.SubscriptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    private final ValidationService validationService;

    @Override
    public WebResponse<String> subscribe(SubscribeRequest request) {
        validationService.validate(request);

        Subscription subscriptionFromDb =
                subscriptionRepository.findByMemberIdAndProgramId(request.getMemberId(), request.getProgramId());
        if (null == subscriptionFromDb)
            throw new ResponseStatusException(HttpStatus.CONFLICT);

        subscriptionRepository.save(SubscriptionUtil.mapSubcribeRequestToSubscription(request));

        return WebResponse.<String> builder()
                .message("OK")
                .build();
    }

    @Override
    public WebResponse<String> cancel(SubscribeCancelRequest request) {
        validationService.validate(request);

        Subscription subscriptionFromDb =
                subscriptionRepository.findByMemberIdAndProgramId(request.getMemberId(), request.getProgramId());
        if (null == subscriptionFromDb)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        subscriptionFromDb.setSubscriptionStatus(SubscriptionStatus.builder()
                        .id(Constant.SUBSCRIPTION_STATUS.CANCEL_ID)
                .build());

        subscriptionRepository.save(subscriptionFromDb);

        return WebResponse.<String> builder()
                .message("OK")
                .build();
    }

    @Override
    public WebResponse<String> extend(SubscribeExtendRequest request) {
        validationService.validate(request);

        Subscription subscriptionFromDb =
                subscriptionRepository.findByMemberIdAndProgramId(request.getMemberId(), request.getProgramId());
        if (null == subscriptionFromDb)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        subscriptionFromDb.setMeetingRemainingDuration(subscriptionFromDb.getMeetingRemainingDuration() + request.getMeetingDuration());
        subscriptionFromDb.setSubscriptionStatus(SubscriptionStatus.builder()
                .id(Constant.SUBSCRIPTION_STATUS.ACTIVE_ID)
                .build());

        subscriptionRepository.save(subscriptionFromDb);

        return WebResponse.<String> builder()
                .message("OK")
                .build();
    }
}
