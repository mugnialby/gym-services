package com.alby.gymservices.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthLoginRequest {

    @NotBlank
    @Length(max = 64)
    private String email;

    @NotBlank
    @Length(max = 128)
    private String password;
}
