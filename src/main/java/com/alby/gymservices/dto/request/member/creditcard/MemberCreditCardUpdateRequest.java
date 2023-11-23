package com.alby.gymservices.dto.request.member.creditcard;

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
public class MemberCreditCardUpdateRequest {

    @NotNull
    @Digits(integer = 12, fraction = 0)
    private Long id;

    @Length(max = 128)
    private String cardNo;

    @Length(max = 128)
    private String cardHolderName;

    @Length(max = 128)
    private String cvv;

    @Length(max = 128)
    private String expiredDate;

    @NotBlank
    @Length(max = 64)
    private String modifiedBy;
}
