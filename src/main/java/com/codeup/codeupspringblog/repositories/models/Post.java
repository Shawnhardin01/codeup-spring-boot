//package com.codeup.codeupspringblog.repositories.models;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//@Entity
//@Table(name="posts")
//public class Post extends Number {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(length=10, nullable = false)
//    private String date;
//
//    @Column(length=1024, nullable = false)
//    private String title;
//
//    @Column(length=1024, nullable = false)
//    private String author;
//
//    @Column(length=65535, nullable = false)
//    private String body;
//
//    @ManyToOne
//    @JoinColumn (name = "user_id")
//    private User user;
//
//    @Override
//    public int intValue() {
//        return 0;
//    }
//
//    @Override
//    public long longValue() {
//        return 0;
//    }
//
//    @Override
//    public float floatValue() {
//        return 0;
//    }
//
//    @Override
//    public double doubleValue() {
//        return 0;
//    }
//}
