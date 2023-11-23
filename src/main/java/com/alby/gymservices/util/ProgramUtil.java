package com.alby.gymservices.util;

import com.alby.gymservices.dto.request.member.MemberRegisterRequest;
import com.alby.gymservices.dto.response.programs.ProgramResponse;
import com.alby.gymservices.entity.member.Member;
import com.alby.gymservices.entity.program.Program;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;

@NoArgsConstructor
@Builder
public class ProgramUtil {

    public static ProgramResponse mapProgramToProgramResponse(Program request) {
        return ProgramResponse.builder()
                .programName(request.getName())
                .build();
    }
}
