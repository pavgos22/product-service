package com.example.productservice.translator;

import com.example.productservice.entity.Category;
import com.example.productservice.entity.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper
public abstract class CategoryToCategoryDTO {

    public CategoryDTO toCategoryDTO(Category category){
        return  translateToCategoryDTO(category);
    }

    @Mappings({})
    protected abstract CategoryDTO translateToCategoryDTO(Category category);
}
