package com.alby.gymservices.serviceimpl;

import com.alby.gymservices.dto.request.program.ProgramByCategoryRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.programs.ProgramResponse;
import com.alby.gymservices.entity.program.Program;
import com.alby.gymservices.repository.ProgramRepository;
import com.alby.gymservices.service.ProgramService;
import com.alby.gymservices.service.ValidationService;
import com.alby.gymservices.util.ProgramUtil;
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

        Program programFromDb = programRepository.findByProgramCategory(request.getCategoryId());
        if (null == programFromDb)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return WebResponse.<ProgramResponse> builder()
                .data(ProgramUtil.mapProgramToProgramResponse(programFromDb))
                .message("OK")
                .build();
    }
}
