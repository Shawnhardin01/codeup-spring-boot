package com.codeup.models;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Post{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length=10, nullable = false)
    private String date;

    @Column(length=1000, nullable = false)
    private String title;

    @Column(length=1000, nullable = false)
    private String author;

    @Column(length=60000, nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

}
