package com.alby.gymservices.controller;

import com.alby.gymservices.dto.request.subscription.SubscribeCancelRequest;
import com.alby.gymservices.dto.request.subscription.SubscribeExtendRequest;
import com.alby.gymservices.dto.request.subscription.SubscribeRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping(
            path = "/subscribe",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> subscribe(SubscribeRequest request) {
        return subscriptionService.subscribe(request);
    }

    @PostMapping(
            path = "/cancel",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> cancel(SubscribeCancelRequest request) {
        return subscriptionService.cancel(request);
    }

    @PostMapping(
            path = "/extend",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> extend(SubscribeExtendRequest request) {
        return subscriptionService.extend(request);
    }
}
