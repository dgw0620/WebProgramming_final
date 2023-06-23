package com.web.webprogramming_final.web;

import com.web.webprogramming_final.service.CalendarService;
import com.web.webprogramming_final.web.dto.ScheduleReqDto;
import com.web.webprogramming_final.web.dto.ScheduleResDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/calendar")
public class CalendarController {

    private static final Logger log = LoggerFactory.getLogger(CalendarController.class);

    private final CalendarService calendarService;

    @PostMapping("/add")
    public void addSchedule(@RequestBody ScheduleReqDto scheduleReqDto) {
        calendarService.save(scheduleReqDto);
    }

    @GetMapping("/all/{user_idx}")
    public List<ScheduleResDto> getAllSchedules(@PathVariable Long user_idx) {
        return calendarService.findAllByUser_idx(user_idx);
    }

    @PostMapping("/delete")
    public void deleteSchedule(@RequestBody ScheduleReqDto scheduleReqDto) {
        calendarService.delete(scheduleReqDto);
    }
}
