package com.alby.gymservices.util;

import com.alby.gymservices.dto.request.member.MemberRegisterRequest;
import com.alby.gymservices.dto.request.member.creditcard.MemberCreditCardRegisterRequest;
import com.alby.gymservices.dto.response.auth.AuthLoginResponse;
import com.alby.gymservices.entity.member.Member;
import com.alby.gymservices.entity.member.MemberCreditCard;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Builder
public class MemberUtil {

    public static Member mapMemberRegisterRequestToMember(MemberRegisterRequest request) {
        List<MemberCreditCard> memberCreditCards = new ArrayList<>();
        memberCreditCards.add(MemberCreditCard.builder()
                        .
                .build());

        return Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()))
                .phoneNo(request.getPhoneNo())
                .memberCreditCard(mapMemberCcRegisterRequestToMemberCc(request.getMemberCreditCardRegisterRequest()))
                .createdBy(request.getCreatedBy())
                .build();
    }

    public static MemberCreditCard mapMemberCcRegisterRequestToMemberCc(MemberCreditCardRegisterRequest request) {
        return MemberCreditCard.builder()
                .cardNo(request.getCardNo())
                .cardHolderName(request.getCardHolderName())
                .cvv(request.getCvv())
//                .expiredDate(request.getExpiredDate())
                .createdBy(request.getCreatedBy())
                .build();
    }

    public static AuthLoginResponse mapMemberToAuthLoginResponse(Member request) {
        return AuthLoginResponse.builder()
                .token(request.getToken())
                .build();
    }
}
