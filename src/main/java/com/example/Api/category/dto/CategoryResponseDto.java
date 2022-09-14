package com.example.Api.category.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CategoryResponseDto {
    private long categoryId;
    private String categoryName;
}
