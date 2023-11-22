package com.alby.gymservices.dto.request.token;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenRefreshRequest {

    @NotBlank
    @Length(max = 64)
    private String email;

    @NotBlank
    @Length(max = 256)
    private String token;
}
