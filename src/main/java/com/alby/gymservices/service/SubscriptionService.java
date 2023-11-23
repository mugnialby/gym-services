package com.alby.gymservices.service;

import com.alby.gymservices.dto.request.subscription.SubscribeCancelRequest;
import com.alby.gymservices.dto.request.subscription.SubscribeExtendRequest;
import com.alby.gymservices.dto.request.subscription.SubscribeRequest;
import com.alby.gymservices.dto.response.WebResponse;

public interface SubscriptionService {

    WebResponse<String> subscribe(SubscribeRequest request);

    WebResponse<String> cancel(SubscribeCancelRequest request);

    WebResponse<String> extend(SubscribeExtendRequest request);
}
