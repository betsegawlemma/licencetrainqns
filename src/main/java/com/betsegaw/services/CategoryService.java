package com.betsegaw.services;


import com.betsegaw.entities.Category;

import java.util.Set;

public interface CategoryService {
    public Set<Category> getCategories();
    public Category findById(Long categoryId);
    public Category findByDescription(String description);
    public  Category saveCategory(Category category);
    public void deleteById(Long categoryId);
}
