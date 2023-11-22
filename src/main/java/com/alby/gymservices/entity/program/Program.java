package com.alby.gymservices.entity.program;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "program")
@EntityListeners({
        AuditingEntityListener.class
})
public class Program {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "program_id_seq"
    )
    @SequenceGenerator(
            name = "program_id_seq",
            sequenceName = "program_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "program_name")
    private String programName;

    private BigDecimal price;

    @Column(name = "meeting_duration")
    private Integer meetingDuration;

    @OneToOne
    private ProgramCategory programCategory;

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
