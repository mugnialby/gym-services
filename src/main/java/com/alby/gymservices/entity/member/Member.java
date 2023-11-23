package com.alby.gymservices.entity.member;

import com.alby.gymservices.entity.member.validity.MemberValidity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

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

    @OneToOne
    @JoinColumn(
            name = "member_validity_id",
            referencedColumnName = "id"
    )
    private MemberValidity memberValidity;

    @OneToOne
    @JoinColumn(
            name = "id",
            referencedColumnName = "member_id"
    )
    private MemberCreditCard memberCreditCard;

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
