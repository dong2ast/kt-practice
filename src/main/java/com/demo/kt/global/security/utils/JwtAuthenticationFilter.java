package com.demo.kt.global.security.utils;

import static com.demo.kt.global.security.utils.AuthWhiteList.AUTH_WHITELIST_DEFAULT;
import static com.demo.kt.global.security.utils.AuthWhiteList.AUTH_WHITELIST_WILDCARD;

import com.demo.kt.global.security.jwt.JwtProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        if (AUTH_WHITELIST_DEFAULT.stream()
                .anyMatch(whiteUrl -> request.getRequestURI().equals(whiteUrl))) {
            filterChain.doFilter(request, response);
            return;
        }

        if (AUTH_WHITELIST_WILDCARD.stream()
                .anyMatch(whiteUrl -> request.getRequestURI()
                        .startsWith(whiteUrl.substring(0, whiteUrl.length() - 3)))) {
            filterChain.doFilter(request, response);
            return;
        }

        // Request의 Header에서 JWT 토큰을 String으로 가져옴
        final String token = getJwtFromRequest(request);
        if (jwtProvider.validateAccessToken(token)) {
            String memberId = jwtProvider.getUserFromJwt(token);
            UserAuthentication authentication = new UserAuthentication(memberId, null, null);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length());
        }
        return null;
    }

}
