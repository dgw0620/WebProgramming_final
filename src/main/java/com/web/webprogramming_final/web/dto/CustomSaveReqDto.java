package com.web.webprogramming_final.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CustomSaveReqDto {
    private Long user_idx;
    private String color;

    @Builder
    public CustomSaveReqDto(Long user_idx, String color) {
        this.user_idx = user_idx;
        this.color = color;
    }
}
