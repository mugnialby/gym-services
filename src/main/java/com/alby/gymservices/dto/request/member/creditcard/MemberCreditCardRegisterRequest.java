package com.alby.gymservices.dto.request.member.creditcard;

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
public class MemberCreditCardRegisterRequest {

    @NotBlank
    @Length(max = 128)
    private String cardNo;

    @NotBlank
    @Length(max = 128)
    private String cardHolderName;

    @NotBlank
    @Length(max = 128)
    private String cvv;

    @NotBlank
    @Length(max = 128)
    private String expiredDate;

    @NotBlank
    @Length(max = 64)
    private String createdBy;
}
