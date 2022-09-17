package com.example.Api.member;


import com.example.Api.oauth.PrincipalDetails;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.security.Principal;

@RestController
@RequestMapping("/member")
@Validated
@RequiredArgsConstructor
public class memberController {

    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MemberRepository memberRepository;
    private final MemberMapper mapper;

/*
    // 5. 유저 삭제 (회원 탈퇴)



//    @GetMapping("/all") // 모든 유저 조회
//    public ResponseEntity memberall(@Positive @RequestParam int page){
//        Page<Member> page1 =
//        return new ResponseEntity<>(page1,HttpStatus.ACCEPTED);
//    }
*/
@PostMapping("/signup")
@ApiOperation(value = "회원가입")
public ResponseEntity signup(@Validated @RequestBody MemberPostDto memberPostDto) {
    Member member = mapper.memberPostDtoToMember(memberPostDto);
    member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
    member.setRoles("USER");
    Member response = memberService.createMember(member);

    return new ResponseEntity<>(response , HttpStatus.OK);
}
//@PatchMapping("/{member-id}")
//@ApiOperation(value = "회원 정보 수정")
//public ResponseEntity update(@Validated @RequestBody MemberPatchDto memberPatchDto){
//
//    Member member = mapper.memberPatchDtoToMember(memberPatchDto);
//    member.setUsername("바뀐이메일");
//    Member response = memberService.createMember(member);
//
//    return new ResponseEntity<>(response,HttpStatus.OK);
//}
//    @GetMapping("/{member-id}")
//    @ApiOperation(value = "마이 페이지")// 유저 상세 페이지
//    public ResponseEntity memberPage(@PathVariable("member-id") @Positive long id){
//
//        Member response = memberService.findMember(id);
//        response.setRoles("USER");
//        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
//    }
    @GetMapping("/test")
    public String getMyInfo(Principal principal){
        return principal.toString();
    }

}
