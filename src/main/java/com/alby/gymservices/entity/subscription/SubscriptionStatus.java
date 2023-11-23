package com.alby.gymservices.entity.subscription;

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
@Table(name = "subscription_status")
@EntityListeners({
        AuditingEntityListener.class
})
public class SubscriptionStatus {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subscription_status_id_seq"
    )
    @SequenceGenerator(
            name = "subscription_status_id_seq",
            sequenceName = "subscription_status_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String name;

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
