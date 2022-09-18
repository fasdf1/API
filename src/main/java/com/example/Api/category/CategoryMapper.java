package com.example.Api.category;

import com.example.Api.member.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category categoryPostDtoToCategory(CategoryPostDto categoryPostDto);
}
