package com.alby.gymservices.entity.payment;

import com.alby.gymservices.entity.member.Member;
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

    @OneToOne
    @JoinColumn(
            name = "member_id",
            referencedColumnName = "id"
    )
    private Member member;

    private BigDecimal total;

    @OneToOne
    @JoinColumn(
            name = "payment_status_id",
            referencedColumnName = "id"
    )
    private PaymentStatus paymentStatus;
}
