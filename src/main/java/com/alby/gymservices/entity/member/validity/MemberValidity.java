package com.alby.gymservices.entity.member.validity;

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
@Table(name = "member_validity")
@EntityListeners({
        AuditingEntityListener.class
})
public class MemberValidity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_validity_id_seq"
    )
    @SequenceGenerator(
            name = "member_validity_id_seq",
            sequenceName = "member_validity_id_seq",
            allocationSize = 1
    )
    private int id;

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
