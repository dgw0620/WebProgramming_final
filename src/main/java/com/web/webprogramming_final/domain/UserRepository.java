package com.web.webprogramming_final.domain;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByIdAndPw(String id, String pw);
    User findByIdx(Long idx);
}
