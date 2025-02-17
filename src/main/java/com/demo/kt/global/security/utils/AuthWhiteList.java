package com.demo.kt.global.security.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AuthWhiteList {

    public static final List<String> AUTH_WHITELIST_DEFAULT = Arrays.asList(
            "/api/v1/members/signup", "/api/v1/members/login", "/api/v1/members/reissue", "/",
            "/error"
    );

    public static final List<String> AUTH_WHITELIST_WILDCARD = Arrays.asList(
            "/swagger-ui/**", "/swagger-resources/**", "/api-docs/**", "/v3/api-docs/**",
            "/actuator/**", "/api/v1/code-groups/**", "/api/v1/code-details/**"
    );

    public static final String[] AUTH_WHITELIST = Stream.concat(
            AUTH_WHITELIST_DEFAULT.stream(),
            AUTH_WHITELIST_WILDCARD.stream()
    ).toArray(String[]::new);

}
