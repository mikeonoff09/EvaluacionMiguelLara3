package com.mikels.test3.evaluacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikels.test3.evaluacion.models.Post;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findById(Long id);

    Optional<Post> findByTitle(String title);

    // Método adicional para buscar por ID y título
    Optional<Post> findByIdAndTitle(Long id, String title);
}