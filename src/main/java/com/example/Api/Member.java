package com.example.Api;

import lombok.*;
import nonapi.io.github.classgraph.json.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //@Email
    
    private String userName; //이렇게하고 이메일 그냥 받으면 됨
    private String nickName;
    private String password;



}
