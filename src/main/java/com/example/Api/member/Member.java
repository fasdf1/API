package com.example.Api.member;

import com.example.Api.category.Category;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //@Email
    @Column
    private String email;
    @Column
    private String nickName;
    @Column
    private String password;
    @Column
    private String role;

   /* private Category category = null;*/

//    private List<productHearts> productHearts = new ArrayList<>();
//    private List<reviewHearts> reviewHearts = new ArrayList<>();

//    private long points;
//    private String grade;
    //구현 아직 화정되지 않음
    private LocalDate createdAt;



}
