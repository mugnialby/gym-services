package com.alby.gymservices.entity.program;

import com.alby.gymservices.entity.subscription.Subscription;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

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

    private String name;

    @Column(name = "price_per_meeting")
    private BigDecimal pricePerMeeting;

    @Column(name = "meeting_duration")
    private Integer meetingDuration;

    @ManyToOne
    @JoinColumn(
            name = "program_category",
            referencedColumnName = "id"
    )
    private ProgramCategory programCategory;

    @OneToMany
    @JoinColumn(
            name = "program_id",
            referencedColumnName = "id"
    )
    private List<ProgramSchedule> programSchedule;

    @ManyToOne
    @JoinColumn(
            name = "program_id",
            referencedColumnName = "id"
    )
    private Subscription subscription;

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
