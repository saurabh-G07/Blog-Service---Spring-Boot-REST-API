package com.example.blogservice.repository;

import com.example.blogservice.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findAll(Pageable pageable);
}