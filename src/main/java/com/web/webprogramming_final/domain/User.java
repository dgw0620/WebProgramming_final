package com.web.webprogramming_final.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String pw;

    @Column
    private String color;

    @Builder
    public User(Long idx, String id, String pw, String color) {
        this.idx = idx;
        this.id = id;
        this.pw = pw;
        this.color = color;
    }

    public void update(String color) {
        this.color = color;
    }
}
