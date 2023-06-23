package com.web.webprogramming_final.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByUser_idx(Long user_idx);
    Schedule findByTitleAndStartAndEndAndUser_idx(String title, String start, String end, Long user_idx);
}
