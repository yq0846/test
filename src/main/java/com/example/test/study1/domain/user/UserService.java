package com.example.test.study1.domain.user;

import com.example.test.study1.domain.user.entity.UserEntity;
import com.example.test.study1.infrastructure.user.UserRepository;
import com.example.test.study1.presentation.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDto::from)
                .toList();
    }

    public UserDto findById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자 데이터가 존재하지 않습니다."));
        return UserDto.from(userEntity);
    }

    @Transactional
    public void create(UserDto create) {
        userRepository.save(create.toUser());
    }

    @Transactional
    public void update(UserDto update) {
        UserEntity userEntity = userRepository.findById(update.getId())
                .orElseThrow(() -> new IllegalArgumentException("사용자 데이터가 존재하지 않습니다."));
        userEntity.update(update);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
