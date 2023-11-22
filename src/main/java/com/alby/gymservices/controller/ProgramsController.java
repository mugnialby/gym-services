package com.alby.gymservices.controller;

import com.alby.gymservices.dto.request.program.ProgramByCategoryRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.programs.ProgramResponse;
import com.alby.gymservices.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/programs")
@RequiredArgsConstructor
public class ProgramsController {

    private final ProgramService programsService;

    @GetMapping(
            path = "/categories",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ProgramResponse> getProgramByCategories(ProgramByCategoryRequest request) {
        return programsService.getProgramByCategory(request);
    }

}
