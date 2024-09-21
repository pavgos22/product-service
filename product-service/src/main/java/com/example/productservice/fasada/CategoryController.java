package com.example.productservice.fasada;


import com.example.productservice.entity.CategoryDTO;
import com.example.productservice.entity.Response;
import com.example.productservice.exceptions.ObjectExistInDBException;
import com.example.productservice.mediator.CategoryMediator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryMediator categoryMediator;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoryDTO>> getCategory(){
        return categoryMediator.getCategory();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
        try {
            categoryMediator.createCategory(categoryDTO);
        } catch (ObjectExistInDBException e) {
            return ResponseEntity.status(400).body(new Response("Object exist in DB"));
        }
        return ResponseEntity.ok(new Response("Operation end Success"));
    }
}
