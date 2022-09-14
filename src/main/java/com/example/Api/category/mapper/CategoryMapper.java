package com.example.Api.category.mapper;

import com.example.Api.category.Category;
import com.example.Api.category.dto.CategoryPatchDto;
import com.example.Api.category.dto.CategoryPostDto;
import com.example.Api.category.dto.CategoryResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    default Category categoryPostDtoToCategory(CategoryPostDto categoryPostDto){
        Category category = new Category();
        category.setCategoryName(categoryPostDto.getCategoryName());
        return category;
    }
    Category categoryPatchDtoToUser(CategoryPatchDto categoryPatchDto);
    CategoryResponseDto categoryToCategoryResponseDto(Category category);

    List<CategoryResponseDto> categoriesToCategoryResponseDtos(List<Category> categories);
}
