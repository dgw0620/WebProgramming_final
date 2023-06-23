package com.web.webprogramming_final.web;

import com.web.webprogramming_final.service.UserService;
import com.web.webprogramming_final.web.dto.CustomSaveReqDto;
import com.web.webprogramming_final.web.dto.UserSaveReqDto;
import com.web.webprogramming_final.web.dto.UserSaveResDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(CalendarController.class);

    private final UserService userService;

    @PostMapping("/add")
    public void saveUser(@RequestBody UserSaveReqDto userSaveReqDto) {
        userService.save(userSaveReqDto);
    }

    @PostMapping("/login")
    public UserSaveResDto loginUser(@RequestBody UserSaveReqDto userSaveReqDto) {
        return userService.loginUser(userSaveReqDto);
    }

    @PatchMapping("/save")
    public void saveCustom(@RequestBody CustomSaveReqDto customSaveReqDto) {
        userService.update(customSaveReqDto);
    }
}
