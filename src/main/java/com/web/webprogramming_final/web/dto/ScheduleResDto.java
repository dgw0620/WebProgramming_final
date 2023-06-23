package com.web.webprogramming_final.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScheduleResDto {
    private String title;
    private String start;
    private String end;
    private String color;

    @Builder
    public ScheduleResDto(String title, String start, String end, String color) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.color = color;
    }
}
