package com.betsegaw.services;

import com.betsegaw.entities.Category;
import com.betsegaw.exception.NotFoundException;
import com.betsegaw.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getCategories() {
        Set<Category> categories = new HashSet<>();
        categoryRepository.findAll().iterator().forEachRemaining(categories::add);
        return categories;
    }

    @Override
    public Category findById(Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if(!categoryOptional.isPresent()){
            throw new NotFoundException("Category Not Found. For ID value: "+categoryId.toString());
        }
        return categoryOptional.get();
    }

    @Override
    public Category findByDescription(String description) {
        Optional<Category> categoryOptional = categoryRepository.findBydescription(description);
        if(!categoryOptional.isPresent()){
            throw new NotFoundException("Category Not Found. For Description value: "+description);
        }
        return categoryOptional.get();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
