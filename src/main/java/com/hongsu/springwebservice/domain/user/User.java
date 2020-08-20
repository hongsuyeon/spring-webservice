package com.hongsu.springwebservice.domain.user;

import com.hongsu.springwebservice.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;
/*
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;*/

}
