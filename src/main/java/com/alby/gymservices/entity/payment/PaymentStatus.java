package com.alby.gymservices.entity.payment;

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
@Table(name = "payment_status")
@EntityListeners({
        AuditingEntityListener.class
})
public class PaymentStatus {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_status_id_seq"
    )
    @SequenceGenerator(
            name = "payment_status_id_seq",
            sequenceName = "payment_status_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "name")
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
