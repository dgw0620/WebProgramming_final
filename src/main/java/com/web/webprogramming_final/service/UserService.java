package com.web.webprogramming_final.service;

import com.web.webprogramming_final.domain.User;
import com.web.webprogramming_final.domain.UserRepository;
import com.web.webprogramming_final.web.dto.CustomSaveReqDto;
import com.web.webprogramming_final.web.dto.UserSaveReqDto;
import com.web.webprogramming_final.web.dto.UserSaveResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void save(UserSaveReqDto userSaveReqDto) {
        userRepository.save(userSaveReqDto.toEntity());
    }

    @Transactional
    public UserSaveResDto loginUser(UserSaveReqDto userSaveReqDto) {
        User user = userRepository.findByIdAndPw(userSaveReqDto.getId(), userSaveReqDto.getPw());
        UserSaveResDto userSaveResDto = UserSaveResDto.builder()
                .idx(user.getIdx())
                .color(user.getColor())
                .build();
        return userSaveResDto;
    }

    @Transactional
    public User findByIdx(Long idx) {
        return userRepository.findByIdx(idx);
    }

    @Transactional
    public void update(CustomSaveReqDto customSaveReqDto) {
        User user = findByIdx(customSaveReqDto.getUser_idx());
        user.update(customSaveReqDto.getColor());
    }
}
