package com.example.blogservice.service;

import com.example.blogservice.model.Blog;
import com.example.blogservice.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Page<Blog> getAllBlogs(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public Blog updateBlog(Long id, Blog newBlog) {
        return blogRepository.findById(id).map(blog -> {
            blog.setTitle(newBlog.getTitle());
            blog.setContent(newBlog.getContent());
            return blogRepository.save(blog);
        }).orElseThrow(() -> new RuntimeException("Blog not found"));
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}