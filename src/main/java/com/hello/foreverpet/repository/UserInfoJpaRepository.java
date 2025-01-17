package com.hello.foreverpet.repository;

import com.hello.foreverpet.domain.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoJpaRepository extends JpaRepository<UserInfo, Long> {

    Optional<UserInfo> findByUserEmail(String email);
}
