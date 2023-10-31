package com.mikels.test3.evaluacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikels.test3.evaluacion.models.Post;
import com.mikels.test3.evaluacion.repository.PostRepository;

import java.util.Optional;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Optional<Post> findByCriteria(Long id, String title) {
        // Si se proporcionan ambos, ID y título
        if (id != null && title != null) {
            return postRepository.findByIdAndTitle(id, title);
        }
        // Si solo se proporciona el ID
        if (id != null) {
            return postRepository.findById(id);
        }
        // Si solo se proporciona el título
        if (title != null) {
            return postRepository.findByTitle(title);
        }
        return Optional.empty();
    }
}
