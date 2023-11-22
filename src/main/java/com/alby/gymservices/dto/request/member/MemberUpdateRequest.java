package com.alby.gymservices.dto.request.member;

import com.alby.gymservices.dto.request.member.creditcard.MemberCreditCardUpdateRequest;
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
public class MemberUpdateRequest {

    @NotNull
    @Digits(integer = 12, fraction = 0)
    private Long memberId;

    @NotBlank
    @Length(max = 64)
    private String name;

    @NotBlank
    @Length(max = 128)
    private String password;

    private MemberCreditCardUpdateRequest memberCreditCardUpdateRequest;
}
