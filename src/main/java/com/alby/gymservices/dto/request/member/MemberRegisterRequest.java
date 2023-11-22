package com.alby.gymservices.dto.request.member;

import com.alby.gymservices.dto.request.member.creditcard.MemberCreditCardRegisterRequest;
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
public class MemberRegisterRequest {
    
    @NotBlank
    @Length(max = 64)
    private String name;

    @NotBlank
    @Length(max = 64)
    private String email;

    @NotBlank
    @Length(max = 128)
    private String password;

    @NotBlank
    @Length(max = 16)
    private String phoneNo;

    @NotBlank
    @Length(max = 64)
    private String createdBy;

    private MemberCreditCardRegisterRequest memberCreditCardRegisterRequest;
}
