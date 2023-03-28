package com.codeup.codeupspringblog.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.codeup.codeupspringblog.repositories.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long>{

    List<Post> findByTitle(String title);
    List<Post> findByAuthor(String Author);


    @Query("from Post p where p.title like %:name%")
    List<Post> findLikeName(@Param("name") String name);
}


