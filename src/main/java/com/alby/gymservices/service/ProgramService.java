package com.alby.gymservices.service;

import com.alby.gymservices.dto.request.program.ProgramByCategoryRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.programs.ProgramResponse;

public interface ProgramService {

    WebResponse<ProgramResponse> getProgramByCategory(ProgramByCategoryRequest request);
}
