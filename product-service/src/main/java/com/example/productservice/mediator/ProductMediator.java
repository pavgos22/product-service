package com.example.productservice.mediator;

import com.example.productservice.entity.ProductEntity;
import com.example.productservice.entity.SimpleProductDTO;
import com.example.productservice.service.ProductService;
import com.example.productservice.translator.ProductEntityToSimpleProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductMediator {
    private final ProductService productService;
    private final ProductEntityToSimpleProduct productEntityToSimpleProduct;
    public ResponseEntity<?> getProduct(int page, int limit,String name,String category,Float price_min,Float price_max,String data,String sort,String order) {
        List<ProductEntity> product = productService.getProduct(name,category,price_min,price_max,data,page,limit,sort,order);
        if (name == null || name.isEmpty() || data == null || data.isEmpty()){
            List<SimpleProductDTO> simpleProductDTOS = new ArrayList<>();
            long totalCount  = productService.countActiveProducts( name, category, price_min, price_max);
            product.forEach(value->{
                simpleProductDTOS.add(productEntityToSimpleProduct.toSimpleProduct(value));
            });
            return ResponseEntity.ok().header("X-Total-Count", String.valueOf(totalCount)).body(simpleProductDTOS);
        }
        return ResponseEntity.ok().body(product);
    }
}
