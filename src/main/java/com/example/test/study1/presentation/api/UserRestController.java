package com.example.test.study1.presentation.api;

import com.example.test.study1.application.UserPaymentUseCase;
import com.example.test.study1.presentation.dto.UserDto;
import com.example.test.study1.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final UserPaymentUseCase userPaymentUseCase;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAlluser() {
        List<UserDto> userList = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @GetMapping("/get/{key}")
    public ResponseEntity<UserDto> getUser(@PathVariable("key") Long id) {
        UserDto user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/post")
    public ResponseEntity<Void> createUser(@RequestBody UserDto user) {
        userService.create(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/put")
    public ResponseEntity<Void> updateUser(@RequestBody UserDto user) {
        userService.update(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/{key}")
    public ResponseEntity<Void> deleteUser(@PathVariable("key") Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/facam-put/{payment-id},{user-id}")
    public ResponseEntity<Void> calculate(@PathVariable("payment-id") Long paymentId, @PathVariable("user-id") Long userId) {
        userPaymentUseCase.calculate(paymentId, userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
