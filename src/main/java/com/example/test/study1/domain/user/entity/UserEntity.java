package com.example.test.study1.domain.user.entity;

import com.example.test.study1.presentation.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;


@Getter
@Setter
@Entity
@Table(name="user_detail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;                //사용자 ID
    private String name;            //사용자 명
    private Long availableAmount;   //보유 금액

    @Builder
    public UserEntity(
            Long id,
            String name,
            Long availableAmount
    ) {
        this.id = id;
        this.name = name;
        this.availableAmount = availableAmount;
    }

    public void update(UserDto update) {
        this.availableAmount = update.getAvailableAmount();
    }
}
