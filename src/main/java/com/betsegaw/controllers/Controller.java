package com.betsegaw.controllers;

import com.betsegaw.services.*;
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

    public Controller(AdminService adminService, CategoryService categoryService, QuestionService questionService, TestTakerService testTakerService, UserService userService) {
        this.adminService = adminService;
        this.categoryService = categoryService;
        this.questionService = questionService;
        this.testTakerService = testTakerService;
        this.userService = userService;
    }
}
