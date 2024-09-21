package com.example.productservice.translator;

import com.example.productservice.entity.ProductEntity;
import com.example.productservice.entity.SimpleProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class ProductEntityToSimpleProduct {
    public SimpleProductDTO toSimpleProduct(ProductEntity productEntity){
        return toSimpleProductDTO(productEntity);
    }

    @Mappings({
            @Mapping(target = "imageUrl", expression = "java(getImageUrl(productEntity.getImageUrls()))")
    })
    protected abstract SimpleProductDTO toSimpleProductDTO(ProductEntity productEntity);

    String getImageUrl(String[] images){
        return  images != null && images.length >= 1 ? images[0] : null;
    }
}
