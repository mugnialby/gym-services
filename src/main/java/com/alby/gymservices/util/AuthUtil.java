package com.alby.gymservices.util;

import com.alby.gymservices.dto.request.member.MemberRegisterRequest;
import com.alby.gymservices.dto.response.auth.AuthLoginResponse;
import com.alby.gymservices.entity.member.Member;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;

@NoArgsConstructor
@Builder
public class AuthUtil {

    public static AuthLoginResponse mapTokenToAuthLoginResponse(String request) {
        return AuthLoginResponse.builder()
                .token(request)
                .build();
    }
}
