package com.example.Api.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    /*
    연관 관계

    member (1)  : productHeart ( N ) : product(1)  //상품 좋아요 기능
    ( member (1) ) : category (1) : product (N) // 상품 추천 기능
    product(1) : review (N) // 상품에 대한 리뷰 작성 기능

     */

    private long id;
    private String imageURL; // 이미지 URL
    private String productName;
    private BigDecimal price;
    private long categoryId;
    private  String company;
    private long views = 0;
    private long hearts = 0;
    private long reviews = 0;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
