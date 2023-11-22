package com.alby.gymservices.entity.subscription;

import com.alby.gymservices.entity.member.Member;
import com.alby.gymservices.entity.program.Program;
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
@Table(name = "subscription")
@EntityListeners({
        AuditingEntityListener.class
})
public class Subscription {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subscription_id_seq"
    )
    @SequenceGenerator(
            name = "subscription_id_seq",
            sequenceName = "subscription_id_seq",
            allocationSize = 1
    )
    private Long id;

    @OneToOne
    private Member member;

    @OneToOne
    private Program program;

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
