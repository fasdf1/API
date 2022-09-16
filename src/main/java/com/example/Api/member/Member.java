package com.example.Api.member;

import com.example.Api.category.Category;
import lombok.*;
import nonapi.io.github.classgraph.json.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //@Email
    private String email;
    private String nickName;
    private String password;
    private String role;

    private Category category = null;

//    private List<productHearts> productHearts = new ArrayList<>();
//    private List<reviewHearts> reviewHearts = new ArrayList<>();

//    private long points;
//    private String grade;
    //구현 아직 화정되지 않음
    private LocalDate createdAt;



}
