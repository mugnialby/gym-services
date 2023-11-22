package com.alby.gymservices.util;

import com.alby.gymservices.dto.response.auth.AuthLoginResponse;
import com.alby.gymservices.dto.response.token.TokenRefreshResponse;
import com.alby.gymservices.entity.member.Member;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class TokenUtil {

    public String generateToken(String email) {
        return new StringBuilder()
                .append(email)
                .append("_")
                .append(System.currentTimeMillis())
                .toString();
    }

    public TokenRefreshResponse mapMemberToTokenRefreshResponse(Member request) {
        return TokenRefreshResponse.builder()
                .token(request.getToken())
                .build();
    }
}
