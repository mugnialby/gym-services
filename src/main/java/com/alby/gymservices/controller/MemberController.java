package com.alby.gymservices.controller;

import com.alby.gymservices.dto.request.member.MemberCheckValidityRequest;
import com.alby.gymservices.dto.request.member.MemberRegisterRequest;
import com.alby.gymservices.dto.request.member.MemberUpdateRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.member.MemberCheckValidityResponse;
import com.alby.gymservices.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {
    
    private final MemberService memberService;
    
    @PostMapping(
            path = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> add(@RequestBody MemberRegisterRequest request) {
        return memberService.add(request);
    }

    @PostMapping(
            path = "/check/valid",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<MemberCheckValidityResponse> checkValidity(@RequestBody MemberCheckValidityRequest request) {
        return memberService.checkValidity(request);
    }

    @PatchMapping(
            path = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> update(@RequestBody MemberUpdateRequest request) {
        return memberService.update(request);
    }
}
