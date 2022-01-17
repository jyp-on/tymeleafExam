package com.example.mythymeleaf.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db column에서 auto_increament를 사용하면 알아서 값이 알아서 증가
    private Long id;

    private String username;
    private String password;
    private Boolean enabled;


    @ManyToMany
    @JoinTable(
            name = "user_role", //연결테이블 이름
            joinColumns = @JoinColumn(name = "user_id"), //유저와 매핑할 조인컬럼 정보를 지정
            inverseJoinColumns = @JoinColumn(name = "role_id"))// Role과 매핑할 조인 컬럼을 지정
    private List<Role> roles = new ArrayList<>();
}
