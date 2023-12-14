package com.example.test.study1.presentation.dto;

import com.example.test.study1.domain.user.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private Long availableAmount;

    @Builder
    public UserDto(
            Long id,
            String name,
            Long availableAmount
    ) {
        this.id = id;
        this.name = name;
        this.availableAmount = availableAmount;
    }

    public static UserDto from(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .availableAmount(userEntity.getAvailableAmount())
                .build();
    }

    public UserEntity toUser() {
        return UserEntity.builder()
                .id(this.id)
                .name(this.name)
                .availableAmount(this.availableAmount)
                .build();
    }
}
