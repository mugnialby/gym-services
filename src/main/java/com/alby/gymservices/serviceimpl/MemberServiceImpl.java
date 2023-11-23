package com.alby.gymservices.serviceimpl;

import com.alby.gymservices.dto.request.member.MemberCheckValidityRequest;
import com.alby.gymservices.dto.request.member.MemberRegisterRequest;
import com.alby.gymservices.dto.request.member.MemberUpdateRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.member.MemberCheckValidityResponse;
import com.alby.gymservices.entity.member.Member;
import com.alby.gymservices.repository.MemberRepository;
import com.alby.gymservices.service.MemberService;
import com.alby.gymservices.service.ValidationService;
import com.alby.gymservices.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

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

        Member member = MemberUtil.mapMemberRegisterRequestToMember(request);
        member.setSalt(BCrypt.gensalt());
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
                .data(MemberUtil.mapMemberValidityToResponse(memberFromDb.getMemberValidity()))
                .message("OK")
                .build();
    }

    @Override
    public WebResponse<String> update(MemberUpdateRequest request) {
        validationService.validate(request);

        Optional<Member> memberFromDb = memberRepository.findById(request.getMemberId());
        if (memberFromDb.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        if (null != request.getName() && !request.getName().isBlank()) {
            memberFromDb.get().setName(request.getName());
        }

        if (null != request.getPassword() && !request.getPassword().isBlank()) {
            memberFromDb.get().setPassword(request.getPassword());
        }

        if (null != request.getMemberCreditCardUpdateRequest().getCardNo()
                && !request.getMemberCreditCardUpdateRequest().getCardNo().isBlank()) {
            memberFromDb.get().getMemberCreditCard().setCardNo(
                    request.getMemberCreditCardUpdateRequest().getCardNo());
        }

        if (null != request.getMemberCreditCardUpdateRequest().getCvv()
                && !request.getMemberCreditCardUpdateRequest().getCvv().isBlank()) {
            memberFromDb.get().getMemberCreditCard().setCvv(
                    request.getMemberCreditCardUpdateRequest().getCvv());
        }

//        if (null != request.getMemberCreditCardUpdateRequest().getExpiredDate()
//                && !request.getMemberCreditCardUpdateRequest().getExpiredDate().isBlank()) {
//            memberFromDb.get().getMemberCreditCard().setExpiredDate(
//                    request.getMemberCreditCardUpdateRequest().getExpiredDate());
//        }

        memberRepository.save(memberFromDb.get());

        return WebResponse.<String> builder()
                .message("OK")
                .build();
    }
}
