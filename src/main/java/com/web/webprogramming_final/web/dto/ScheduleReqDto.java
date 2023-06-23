package com.web.webprogramming_final.web.dto;

import com.web.webprogramming_final.domain.Schedule;
import com.web.webprogramming_final.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScheduleReqDto {
    private String title;
    private String start;
    private String end;
    private String color;
    private Long user_idx;

    @Builder
    public ScheduleReqDto(String title, String start, String end, String color, Long user_idx) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.color = color;
        this.user_idx = user_idx;
    }

    public Schedule toEntity() {
        User user = User.builder()
                .idx(user_idx)
                .build();

        return Schedule.builder()
                .title(title)
                .start(start)
                .end(end)
                .color(color)
                .user(user)
                .build();
    }
}
