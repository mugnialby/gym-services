package com.alby.gymservices.service;

import com.alby.gymservices.dto.request.auth.AuthLoginRequest;
import com.alby.gymservices.dto.request.auth.AuthLogoutRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.auth.AuthLoginResponse;

public interface AuthService {

    WebResponse<AuthLoginResponse> login(AuthLoginRequest request);

    WebResponse<String> logout(AuthLogoutRequest request);
}
