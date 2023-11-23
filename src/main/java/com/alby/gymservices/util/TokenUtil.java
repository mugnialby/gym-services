package com.alby.gymservices.util;

import com.alby.gymservices.dto.response.auth.AuthLoginResponse;
import com.alby.gymservices.dto.response.token.TokenRefreshResponse;
import com.alby.gymservices.entity.member.Member;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;

@NoArgsConstructor
@Builder
public class TokenUtil {

    public static String generateToken(String email, String userSalt) {
        return BCrypt.hashpw(new StringBuilder()
                        .append(email)
                        .append("_")
                        .append(System.currentTimeMillis() + 3600000)
                        .toString(),
                userSalt);
    }

    public static TokenRefreshResponse mapMemberToTokenRefreshResponse(Member request) {
        return TokenRefreshResponse.builder()
                .token(request.getToken())
                .build();
    }
}
