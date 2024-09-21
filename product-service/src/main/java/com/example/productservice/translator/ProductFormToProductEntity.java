package com.example.productservice.translator;

import com.example.productservice.entity.Category;
import com.example.productservice.entity.ProductEntity;
import com.example.productservice.entity.ProductFormDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class ProductFormToProductEntity {

    public ProductEntity toProductEntity(ProductFormDTO productFormDTO){
        return translate(productFormDTO);
    }


    @Mappings({
            @Mapping(expression = "java(translate(productFormDTO.getCategory()))", target = "category"),
            @Mapping(target = "imageUrls",source = "imagesUuid")
    })
    protected abstract ProductEntity translate(ProductFormDTO productFormDTO);


    protected Category translate(String uuid){
        Category category = new Category();
        category.setShortId(uuid);
        return category;
    }


}
