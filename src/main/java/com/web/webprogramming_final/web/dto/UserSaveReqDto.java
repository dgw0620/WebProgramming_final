package com.web.webprogramming_final.web.dto;

import com.web.webprogramming_final.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveReqDto {
    private String id;
    private String pw;

    @Builder
    public UserSaveReqDto(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public User toEntity() {
        return User.builder()
                .id(id)
                .pw(pw)
                .build();
    }
}
