package com.example.blogenboot.service;

import com.example.blogenboot.dao.CategoryDao;
import com.example.blogenboot.dao.PostDao;
import com.example.blogenboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogenService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;
}
