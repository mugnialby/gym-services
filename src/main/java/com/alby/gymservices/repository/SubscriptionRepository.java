package com.alby.gymservices.repository;

import com.alby.gymservices.entity.subscription.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Subscription findByMemberIdAndProgramId(Long memberId, Long programId);
}
