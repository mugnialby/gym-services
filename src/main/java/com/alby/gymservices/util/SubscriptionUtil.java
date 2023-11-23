package com.alby.gymservices.util;

import com.alby.gymservices.dto.request.subscription.SubscribeCancelRequest;
import com.alby.gymservices.dto.request.subscription.SubscribeRequest;
import com.alby.gymservices.entity.member.Member;
import com.alby.gymservices.entity.program.Program;
import com.alby.gymservices.entity.subscription.Subscription;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class SubscriptionUtil {

    public static Subscription mapSubcribeRequestToSubscription(SubscribeRequest request) {
        Member member = Member.builder().
                id(request.getMemberId())
                .build();

        Program program = Program.builder()
                .id(request.getProgramId())
                .build();

        return Subscription.builder()
                .member(member)
                .program(program)
                .build();

    }

    public static Subscription mapSubcribeCancelRequestToSubscription(SubscribeCancelRequest request) {
        Member member = Member.builder().
                id(request.getMemberId())
                .build();

        Program program = Program.builder()
                .id(request.getProgramId())
                .build();

        return Subscription.builder()
                .member(member)
                .program(program)
                .build();

    }
}
