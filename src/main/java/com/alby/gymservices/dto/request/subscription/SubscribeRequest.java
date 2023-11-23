package com.alby.gymservices.dto.request.subscription;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscribeRequest {

    @NotNull
    @Digits(integer = 12, fraction = 0)
    private Long memberId;

    @NotNull
    @Digits(integer = 12, fraction = 0)
    private Long programId;
}
