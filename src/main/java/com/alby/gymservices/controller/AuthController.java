package com.alby.gymservices.controller;

import com.alby.gymservices.dto.request.auth.AuthLoginRequest;
import com.alby.gymservices.dto.request.auth.AuthLogoutRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.auth.AuthLoginResponse;
import com.alby.gymservices.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(
            path = "/login",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AuthLoginResponse> login(AuthLoginRequest request) {
        return authService.login(request);
    }

    @PostMapping(
            path = "/logout",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> logout(AuthLogoutRequest request) {
        return authService.logout(request);
    }
}
