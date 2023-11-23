package com.alby.gymservices.repository;

import com.alby.gymservices.entity.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByMemberIdAndPaymentStatusIdIn(Long memberId, List<Long> paymentStatuses);
}
