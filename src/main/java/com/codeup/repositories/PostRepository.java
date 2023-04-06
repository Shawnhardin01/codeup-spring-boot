package com.codeup.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.codeup.models.Post;

public interface PostRepository extends JpaRepository<Post,Long>{

    Post getByTitle(String title);
}


