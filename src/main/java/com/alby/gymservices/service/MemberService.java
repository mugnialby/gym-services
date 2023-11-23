package com.alby.gymservices.service;

import com.alby.gymservices.dto.request.member.MemberCheckValidityRequest;
import com.alby.gymservices.dto.request.member.MemberRegisterRequest;
import com.alby.gymservices.dto.request.member.MemberUpdateRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.member.MemberCheckValidityResponse;

public interface MemberService {

    WebResponse<String> add(MemberRegisterRequest request);

    WebResponse<MemberCheckValidityResponse> checkValidity(MemberCheckValidityRequest request);

    WebResponse<String> update(MemberUpdateRequest request);
}
