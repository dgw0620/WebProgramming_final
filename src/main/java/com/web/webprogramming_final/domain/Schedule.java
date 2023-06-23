package com.web.webprogramming_final.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(length = 30, nullable = false)
    private String title;

    @Column(length = 30, nullable = false)
    private String start;

    @Column(length = 30, nullable = false)
    private String end;

    @Column(length = 30, nullable = false)
    private String color;

    @ManyToOne
    @JoinColumn
    private User user;

    @Builder
    public Schedule(String title, String start, String end, String color, User user) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.color = color;
        this.user = user;
    }
}
