package com.alby.gymservices.serviceimpl;

import com.alby.gymservices.dto.request.token.TokenRefreshRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.member.MemberCheckValidityResponse;
import com.alby.gymservices.dto.response.token.TokenRefreshResponse;
import com.alby.gymservices.entity.member.Member;
import com.alby.gymservices.repository.MemberRepository;
import com.alby.gymservices.service.TokenService;
import com.alby.gymservices.service.ValidationService;
import com.alby.gymservices.util.MemberUtil;
import com.alby.gymservices.util.TokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final MemberRepository memberRepository;

    private final ValidationService validationService;

    @Override
    public WebResponse<TokenRefreshResponse> refresh(TokenRefreshRequest request) {
        validationService.validate(request);

        Member memberFromDb = memberRepository.findByEmailAndToken(request.getEmail(), request.getToken());
        if (null == memberFromDb)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        memberFromDb.setToken(new TokenUtil().generateToken(request.getEmail()));
        memberFromDb.setModifiedBy("SYSTEM");
        memberRepository.save(memberFromDb);

        return WebResponse.<TokenRefreshResponse> builder()
                .data(new TokenUtil().mapMemberToTokenRefreshResponse(memberFromDb))
                .message("OK")
                .build();
    }
}
