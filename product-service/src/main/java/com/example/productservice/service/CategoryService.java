package com.example.productservice.service;

import com.example.productservice.entity.Category;
import com.example.productservice.entity.CategoryDTO;
import com.example.productservice.exceptions.ObjectExistInDBException;
import com.example.productservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }
    public Optional<Category> findCategoryByShortID(String shortID){
        return categoryRepository.findByShortId(shortID);
    }

    public void create(CategoryDTO categoryDTO) throws ObjectExistInDBException {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setShortId(UUID.randomUUID().toString().replace("-","").substring(0,12));

        categoryRepository.findByName(category.getName()).ifPresent(value->{
            throw new ObjectExistInDBException("Category exist in DB with this name");
        });
        categoryRepository.save(category);
    }
}
