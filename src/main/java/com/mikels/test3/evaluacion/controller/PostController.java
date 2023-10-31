package com.mikels.test3.evaluacion.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mikels.test3.evaluacion.models.Post;
import com.mikels.test3.evaluacion.service.PostService;

import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public ResponseEntity<Post> getPostByCriteria(@RequestParam(required = false) Long id,
                                                  @RequestParam(required = false) String title) {
        Optional<Post> post = postService.findByCriteria(id, title);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
