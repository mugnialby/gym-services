package com.alby.gymservices.entity.payment;

import com.alby.gymservices.entity.member.Member;
import com.alby.gymservices.model.payment.PaymentStatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "payment")
@EntityListeners({
        AuditingEntityListener.class
})
public class Payment {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_id_seq"
    )
    @SequenceGenerator(
            name = "payment_id_seq",
            sequenceName = "payment_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "member_id",
            referencedColumnName = "id"
    )
    private Member member;

    private BigDecimal total;

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatusEnum;
}
