package com.example.Api;

import com.example.Api.member.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
// 1.편비티아이 결과로 인한 카테고리별 상품 1개 씩 총 11개
// 2. 베스트 추천 리뷰
 @Operation(summary = "", description = "hello api example")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
    })


    @GetMapping("/hello")
    public ResponseEntity<Member> hello(@Parameter(description = "이름", required = true, example = "Park") @RequestParam String name) {
        Member member = new Member();

        return ResponseEntity.ok(member);
    }

    @PostMapping("/hello")
    public ResponseEntity<Member> hello2(Member member) {

        return ResponseEntity.ok(member);
    }

    @GetMapping
    public String defalt(){
        return "전체 5 정보, 베스트 리뷰, 편비티아이";
    }

    @GetMapping("/seven11")
    public String CU5(){

        return "seven11";
    }

}