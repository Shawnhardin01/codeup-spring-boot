package com.codeup.models;
 import jakarta.persistence.*;
 import lombok.*;

 import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
//    {
//        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
//        email = copy.email;
//        username = copy.username;
//        password = copy.password;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length=255, nullable = false)
    private String username;

    @Column(length=255, nullable = false)
    private String email;

    @Column(length=255, nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    @ToString.Exclude
    private List<Post> post;

}