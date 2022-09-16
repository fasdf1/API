package com.example.Api.member;


import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/member")
public class memberController {



    // 5. 유저 삭제 (회원 탈퇴)


//    @PostMapping("/login")// 로그인 로직 구현 예정
//    public ResponseEntity login(Member member){
//        return new ResponseEntity<> (member,HttpStatus.CREATED);
//    }

    @PostMapping // 회원가입
    @ApiOperation(value = "회원가입")
    public ResponseEntity signup(@Validated @RequestBody Member member) {


        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }
    @PatchMapping("/{member-id}")
    @ApiOperation(value = "회원 정보 수정")// 회원 정보 수정  -- 구체적인 수정 추가 예정
    public ResponseEntity update(@PathVariable("member-id") @Positive long Id,
                                 @Valid @RequestBody Member member){

return new ResponseEntity<>(member, HttpStatus.OK);
    }



    @GetMapping("/{member-id}")
    @ApiOperation(value = "마이 페이지")// 유저 상세 페이지
    public ResponseEntity memberPage(@PathVariable("member-id") @Positive long Id){
//        Member member1 = new Member(1,"멤버네임","이메일","1234");

        Member member2 = new Member();
        return new ResponseEntity<>(member2,HttpStatus.ACCEPTED);
    }

//    @GetMapping("/all") // 모든 유저 조회
//    public ResponseEntity memberall(@Positive @RequestParam int page){
//        Page<Member> page1 =
//        return new ResponseEntity<>(page1,HttpStatus.ACCEPTED);
//    }

    @DeleteMapping("/{member-id}")
    @ApiOperation(value = "회원탈퇴")//회원 탈퇴
    public ResponseEntity memberDelete(@PathVariable("member-id") @Positive long Id){
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
