package com.demo.kt.global.security.redis;

import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<RefreshToken, String> {

}
