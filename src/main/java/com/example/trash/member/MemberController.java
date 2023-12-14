package com.example.trash.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/get")
    public ResponseEntity<List<MemberEntity>> getAllmembers() {
        List<MemberEntity> member = memberService.findAll();
        return new ResponseEntity<List<MemberEntity>>(member, HttpStatus.OK);
    }

//    ### 전체 조회
//    GET http://localhost:8080/api/member/get

    @GetMapping(value = "/{mbrNo}")
    public ResponseEntity<MemberEntity> getMember(@PathVariable("mbrNo") Long mbrNo) {
        Optional<MemberEntity> member = memberService.findById(mbrNo);
        return new ResponseEntity<MemberEntity>(member.get(), HttpStatus.OK);
    }

//    ### ID로 조회
//    GET http://localhost:8080/api/member/1

    @PostMapping("/post")
    public ResponseEntity<MemberEntity> save(@RequestBody MemberEntity member) {
        return new ResponseEntity<>(memberService.save(member), HttpStatus.OK);
    }

//    ### 생성
//    POST http://localhost:8080/api/member/post
//    Content-Type: application/json
//
//    {
//        "id" : "123",
//            "name" : "456"
//    }
}
