package com.codegym.cms.service;

import com.codegym.cms.model.Blog;

import java.util.List;

public interface BlogService {
    Iterable<Blog>findAll();
    Blog findById(Long id);
    void save (Blog blog);
    void  remove (Blog blog);

}
