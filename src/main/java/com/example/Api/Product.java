package com.example.Api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private long id;
    private String productName;
    private BigDecimal price;
    private  String company;
    private long views;
    private long hearts;
    private List<String> comments;
    private LocalDate createdAt;

}
