package com.example.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {
    private String name;
    private String shortId;

    public CategoryDTO(String name, String shortId) {
        this.name = name;
        this.shortId = shortId;
    }
}
