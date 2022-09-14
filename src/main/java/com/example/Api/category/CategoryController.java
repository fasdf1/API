package com.example.Api.category;


import com.example.Api.category.dto.CategoryPostDto;
import com.example.Api.category.mapper.CategoryMapper;
import com.example.Api.response.SingleResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final int size = 10;
    CategoryMapper categoryMapper;
    @Operation(summary = "", description = "hello api example")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
    })


    // 카테고리 등록
    @PostMapping
    public ResponseEntity registerCategory(@Valid @RequestBody CategoryPostDto categoryPostDto) {

        Category category = categoryMapper.categoryPostDtoToCategory(categoryPostDto);

        return new ResponseEntity<>(
                new SingleResponseDto<>(categoryMapper.categoryToCategoryResponseDto(category)),
                HttpStatus.CREATED);
    }

/*    // 카테고리 수정
    @PatchMapping("/{category-id}")
    public ResponseEntity<String> editCategory(@Parameter(description = "이름", required = true, example = "Park") @RequestParam String name) {
        return ResponseEntity.ok("hello " + name);
    }

    // 카테고리 전체 조회
    @GetMapping
    public ResponseEntity<String> getCategories(@Parameter(description = "이름", required = true, example = "Park") @RequestParam String name) {
        return ResponseEntity.ok("hello " + name);
    }

    // 단일 카테고리 조회
    @GetMapping("/{category-id}")
    public ResponseEntity<String> getCategory(@Parameter(description = "이름", required = true, example = "Park") @RequestParam String name) {
        return ResponseEntity.ok("hello " + name);
    }

    // 카테고리 삭제
    @DeleteMapping("/{category-id}")
    public ResponseEntity deleteCategory(@PathVariable("category-id") long categoryId){
        return new ResponseEntity<>("카테고리 삭제 완료", HttpStatus.OK);
    }*/
}
