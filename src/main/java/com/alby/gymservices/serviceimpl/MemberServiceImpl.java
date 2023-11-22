package com.alby.gymservices.serviceimpl;

import com.alby.gymservices.dto.request.member.MemberCheckValidityRequest;
import com.alby.gymservices.dto.request.member.MemberRegisterRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.member.MemberCheckValidityResponse;
import com.alby.gymservices.entity.member.Member;
import com.alby.gymservices.repository.MemberRepository;
import com.alby.gymservices.service.MemberService;
import com.alby.gymservices.service.ValidationService;
import com.alby.gymservices.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final ValidationService validationService;

    @Override
    @Transactional
    public WebResponse<String> add(MemberRegisterRequest request) {
        validationService.validate(request);

        if (memberRepository.existsByEmail(request.getEmail()))
            throw new ResponseStatusException(HttpStatus.CONFLICT);

        Member member = new MemberUtil().mapMemberRegisterRequestToMember(request);
        memberRepository.save(member);

        return WebResponse.<String> builder()
                .message("OK")
                .build();
    }

    @Override
    public WebResponse<MemberCheckValidityResponse> checkValidity(MemberCheckValidityRequest request) {
        validationService.validate(request);

        Member memberFromDb = memberRepository.findByEmail(request.getEmail());
        if (null == memberFromDb)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return WebResponse.<MemberCheckValidityResponse> builder()
                .data(new MemberUtil().mapMemberValidityToResponse(memberFromDb.getMemberValidity()))
                .message("OK")
                .build();
    }

//    @Override
//    @Transactional
//    public WebResponse<UserResponse> update(UserUpdateRequest request) {
//        validationService.validate(request);
//
//        Users userFromDb = userRepository.findById(request.getUserId())
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//
//        if (Objects.nonNull(request.getUsername())) {
//            if (!request.getUsername().equalsIgnoreCase(userFromDb.getUsername())
//                    && userRepository.existsByUsername(request.getUsername())) {
//                throw new ResponseStatusException(HttpStatus.CONFLICT);
//            }
//
//            userFromDb.setUsername(request.getUsername());
//        }
//
//        if (Objects.nonNull(request.getPassword())) {
//            userFromDb.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
//        }
//
//        if (Objects.nonNull(request.getFirstName())) {
//            userFromDb.setFirstName(request.getFirstName());
//        }
//
//        if (Objects.nonNull(request.getLastName())) {
//            userFromDb.setLastName(request.getLastName());
//        }
//
//        if (Objects.nonNull(request.getStatus())) {
//            userFromDb.setStatus(request.getStatus());
//        }
//
//        if (Objects.nonNull(request.getManagerId())) {
//            userFromDb.setManagerId(request.getManagerId());
//        }
//
//        userRepository.save(userFromDb);
//
//        return WebResponse.<UserResponse>builder()
//                .message("OK")
//                .data(UserUtil.mapUserToUserResponse(userFromDb))
//                .build();
//    }
}
