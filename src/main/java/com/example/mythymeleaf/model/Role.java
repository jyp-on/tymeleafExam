package com.example.mythymeleaf.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db column에서 auto_increament를 사용하면 알아서 값이 알아서 증가
    private Long id;


    private String name; //권한 이름

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();
}
