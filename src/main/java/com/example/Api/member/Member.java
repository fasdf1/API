package com.example.Api.member;

import com.example.Api.audit.Auditable;
import com.example.Api.category.Category;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Member extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String nickName;


   // private Category category;


    private LocalDateTime createdAt;
    private String roles; // User, MANAGER, ADMIN

    public List<String> getRoleList() {
        if(this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public Member(long id,String username,String nickName,String password){

        this.id = id;
        this.username = username;
        this.nickName = nickName;
        this.password = password;
    }
}