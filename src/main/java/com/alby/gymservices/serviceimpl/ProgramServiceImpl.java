package com.alby.gymservices.serviceimpl;

import com.alby.gymservices.dto.request.program.ProgramByCategoryRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.programs.ProgramResponse;
import com.alby.gymservices.entity.member.Member;
import com.alby.gymservices.repository.ProgramRepository;
import com.alby.gymservices.service.ProgramService;
import com.alby.gymservices.service.ValidationService;
import com.alby.gymservices.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    private final ValidationService validationService;

    @Override
    public WebResponse<ProgramResponse> getProgramByCategory(ProgramByCategoryRequest request) {
        validationService.validate(request);

        if (programRepository.findByProgramCategory(request.getCategoryId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT);

        Member member = new MemberUtil().mapMemberRegisterRequestToMember(request);
        memberRepository.save(member);

        return WebResponse.<String> builder()
                .message("OK")
                .build();
    }
}
