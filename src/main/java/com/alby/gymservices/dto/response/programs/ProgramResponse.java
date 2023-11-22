package com.alby.gymservices.dto.response.programs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgramResponse {

    private String programName;

    private BigDecimal price;

    private Integer meetingDuration;

    private String programCategoryName;
}
