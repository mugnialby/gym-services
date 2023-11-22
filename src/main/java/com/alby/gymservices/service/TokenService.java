package com.alby.gymservices.service;

import com.alby.gymservices.dto.request.token.TokenRefreshRequest;
import com.alby.gymservices.dto.response.WebResponse;
import com.alby.gymservices.dto.response.token.TokenRefreshResponse;

public interface TokenService {

    WebResponse<TokenRefreshResponse> refresh(TokenRefreshRequest request);
}
