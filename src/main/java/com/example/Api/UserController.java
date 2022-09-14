package com.example.Api;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class UserController {


    // 1. 로그인 ,
    // 2. 회원가입
    // 3. 유저 상세 페이지
    // 4. 유저 정보 수정
    // 5. 유저 삭제 (회원 탈퇴)

    @PostMapping
    public ResponseEntity signup(Member member) {


        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity userpage(){
        Member member1 = new Member(1L,"홍길동","1234");
        return new ResponseEntity<>(member1,HttpStatus.ACCEPTED);
    }
}
