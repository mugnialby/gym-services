package com.alby.gymservices.serviceimpl;

import com.alby.gymservices.dto.request.auth.AuthLoginRequest;
import com.alby.gymservices.dto.request.auth.AuthLogoutRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.auth.AuthLoginResponse;
import com.alby.gymservices.entity.member.Member;
import com.alby.gymservices.repository.MemberRepository;
import com.alby.gymservices.service.AuthService;
import com.alby.gymservices.service.ValidationService;
import com.alby.gymservices.util.AuthUtil;
import com.alby.gymservices.util.MemberUtil;
import com.alby.gymservices.util.TokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MemberRepository memberRepository;

    private final ValidationService validationService;

    @Override
    public WebResponse<AuthLoginResponse> login(AuthLoginRequest request) {
        validationService.validate(request);

        Member memberFromDb = memberRepository.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (null == memberFromDb)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        String token = TokenUtil.generateToken(memberFromDb.getEmail(), memberFromDb.getSalt());
        memberFromDb.setToken(token);
        memberFromDb.setModifiedBy(memberFromDb.getEmail());
        memberRepository.save(memberFromDb);

        return WebResponse.<AuthLoginResponse> builder()
                .data(AuthUtil.mapTokenToAuthLoginResponse(token))
                .message("OK")
                .build();
    }

    @Override
    public WebResponse<String> logout(AuthLogoutRequest request) {
        validationService.validate(request);

        Member memberFromDb = memberRepository.findByEmailAndToken(request.getEmail(), request.getToken());
        if (null == memberFromDb)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        memberFromDb.setToken(null);
        memberFromDb.setModifiedBy(memberFromDb.getEmail());
        memberRepository.save(memberFromDb);

        return WebResponse.<String> builder()
                .message("OK")
                .build();
    }
}
