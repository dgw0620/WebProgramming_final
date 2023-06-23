package com.web.webprogramming_final.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserSaveResDto {
    private Long idx;
    private String color;

    @Builder
    public UserSaveResDto(Long idx, String color) {
        this.idx = idx;
        this.color = color;
    }
}
