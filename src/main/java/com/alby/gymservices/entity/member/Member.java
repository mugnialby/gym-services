package com.alby.gymservices.entity.member;

import com.alby.gymservices.entity.payment.Payment;
import com.alby.gymservices.model.member.MemberValidityEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "member")
@EntityListeners({
        AuditingEntityListener.class
})
public class Member {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_id_seq"
    )
    @SequenceGenerator(
            name = "member_id_seq",
            sequenceName = "member_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String name;

    private String email;

    private String password;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "member_validity")
    @Enumerated(EnumType.STRING)
    private MemberValidityEnum memberValidityEnum;

    @OneToMany(
            mappedBy = "member",
            fetch = FetchType.LAZY
    )
    private List<MemberCreditCard> memberCreditCards;

    @OneToMany(
            mappedBy = "member",
            fetch = FetchType.LAZY
    )
    private List<Payment> payments;

    private String token;

    private String salt;

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
