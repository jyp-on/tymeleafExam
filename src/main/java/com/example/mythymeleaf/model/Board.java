package com.example.mythymeleaf.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db column에서 auto_increament를 사용하면 알아서 값이 알아서 증가
    private Long id;

    @NotNull
    @Size(min=2, max=30)
    private String title;
    private String content;

}
