package com.example.Api.product;

import com.example.Api.category.Category;
import com.example.Api.review.Review;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductPatchDto {

    /*private  long id = 1;*/
    private String imageURL;
    private String productName;
    private BigDecimal price;
    private  long categoryId;
    private  String company;

}
