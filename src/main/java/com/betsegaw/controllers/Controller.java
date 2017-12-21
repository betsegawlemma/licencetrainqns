package com.betsegaw.controllers;

import com.betsegaw.repositories.AdminRepository;
import com.betsegaw.repositories.CategoryRepository;
import com.betsegaw.repositories.QuestionRepository;
import com.betsegaw.repositories.TestTakerRepository;
import com.betsegaw.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {

   AdminService adminService;
   CategoryService categoryService;
   QuestionService questionService;
   TestTakerService testTakerService;
   UserService userService;

    public Controller() {
    }

    @Autowired
    public Controller(AdminService adminService, CategoryService categoryService, QuestionService questionService, TestTakerService testTakerService, UserService userService) {
        this.adminService = adminService;
        this.categoryService = categoryService;
        this.questionService = questionService;
        this.testTakerService = testTakerService;
        this.userService = userService;
    }
}
