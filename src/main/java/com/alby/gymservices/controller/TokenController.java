package com.alby.gymservices.controller;

import com.alby.gymservices.dto.request.token.TokenRefreshRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.token.TokenRefreshResponse;
import com.alby.gymservices.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/token")
@RequiredArgsConstructor
public class TokenController {

    private final TokenService tokenService;

    @PostMapping(
            path = "/refresh",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<TokenRefreshResponse> refresh(TokenRefreshRequest request) {
        return tokenService.refresh(request);
    }
}
