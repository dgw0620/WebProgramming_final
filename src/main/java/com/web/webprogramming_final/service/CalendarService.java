package com.web.webprogramming_final.service;

import com.web.webprogramming_final.domain.Schedule;
import com.web.webprogramming_final.domain.ScheduleRepository;
import com.web.webprogramming_final.web.dto.ScheduleReqDto;
import com.web.webprogramming_final.web.dto.ScheduleResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CalendarService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public void save(ScheduleReqDto scheduleReqDto) {
        scheduleRepository.save(scheduleReqDto.toEntity());
    }

    @Transactional
    public List<ScheduleResDto> findAllByUser_idx(Long user_idx) {
        List<Schedule> scheduleList = scheduleRepository.findAllByUser_idx(user_idx);
        List<ScheduleResDto> scheduleResDtoList = new ArrayList<>();

        for (Schedule schedule : scheduleList) {
            ScheduleResDto scheduleResDto = ScheduleResDto.builder()
                    .title(schedule.getTitle())
                    .start(schedule.getStart())
                    .end(schedule.getEnd())
                    .color(schedule.getColor())
                    .build();
            scheduleResDtoList.add(scheduleResDto);
        }

        return scheduleResDtoList;
    }

    @Transactional
    public Schedule findByTitleAndStartAndEndAndUser_idx(ScheduleReqDto scheduleReqDto) {
        return scheduleRepository.findByTitleAndStartAndEndAndUser_idx(
                scheduleReqDto.getTitle(),
                scheduleReqDto.getStart(),
                scheduleReqDto.getEnd(),
                scheduleReqDto.getUser_idx());
    }

    @Transactional
    public void delete(ScheduleReqDto scheduleReqDto) {
        Schedule schedule = findByTitleAndStartAndEndAndUser_idx(scheduleReqDto);
        scheduleRepository.delete(schedule);
    }
}
