package com.example.Api.category;



import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @PostMapping //카테고리 등록
    @ApiOperation(value = "카테고리 등록")
    public ResponseEntity postCategory(@Validated@RequestBody Category category){

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PatchMapping("/{category-id}")//카테고리 수정
    @ApiOperation(value = "카테고리 수정")
    public ResponseEntity patchCategory(@PathVariable("category-id") @Positive long categoryId, @Valid @RequestBody Category category)
    {
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/{category-id}") //카테고리 삭제
    @ApiOperation(value = "카테고리 삭제")
    public ResponseEntity categoryDelete(@PathVariable("category-id") @Positive long categoryId){

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
