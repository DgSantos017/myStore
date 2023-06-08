package products.controllers;

import products.dtos.ProductRecordDto;
import products.models.ProductModel;
import products.services.CreateProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateProductController {

    @Autowired
    CreateProductService createProductService;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> createProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        return createProductService.createProduct(productRecordDto);
    }
}
