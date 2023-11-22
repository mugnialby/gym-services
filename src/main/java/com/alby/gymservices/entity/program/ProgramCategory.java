package com.alby.gymservices.entity.program;

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
@Table(name = "program_category")
@EntityListeners({
        AuditingEntityListener.class
})
public class ProgramCategory {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "program_category_id_seq"
    )
    @SequenceGenerator(
            name = "program_category_id_seq",
            sequenceName = "program_category_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "program_category")
    private String programCategory;

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
