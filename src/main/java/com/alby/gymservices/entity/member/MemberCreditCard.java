package com.alby.gymservices.entity.member;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "member_credit_card")
@EntityListeners({
        AuditingEntityListener.class
})
public class MemberCreditCard {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_credit_card_id_seq"
    )
    @SequenceGenerator(
            name = "member_credit_card_id_seq",
            sequenceName = "member_credit_card_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "member_id",
            referencedColumnName = "id"
    )
    private Member member;

    @Column(name = "card_no")
    private String cardNo;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    private String cvv;

    @Column(name = "expired_date")
    private LocalDate expiredDate;

    @Column(name = "created_by")
    private String createdBy;

    @CreatedDate
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "modified_by")
    private String modifiedBy;

    @LastModifiedDate
    @Column(name = "modified_at")
    private Instant modifiedAt;
}
