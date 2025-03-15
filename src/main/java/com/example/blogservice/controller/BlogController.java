package com.example.blogservice.controller;

import com.example.blogservice.model.Blog;
import com.example.blogservice.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    @GetMapping
    public Page<Blog> getAllBlogs(Pageable pageable) {
        return blogService.getAllBlogs(pageable);
    }

    @GetMapping("/{id}")
    public Optional<Blog> getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable Long id, @RequestBody Blog newBlog) {
        return blogService.updateBlog(id, newBlog);
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
    }
}