package com.example.blogenboot.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePosted;
    @OneToMany(mappedBy = "category")
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        post.setCategory(this);
        posts.add(post);
    }

}
