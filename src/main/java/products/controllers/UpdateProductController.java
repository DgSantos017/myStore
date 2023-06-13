package products.controllers;

import org.springframework.web.bind.annotation.*;
import products.dtos.ProductRecordDto;
import products.services.UpdateProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@RestController
public class UpdateProductController {
    @Autowired
    UpdateProductService updateProductService;

    @PatchMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id,
                                                @RequestBody  ProductRecordDto productRecordDto) {
        return updateProductService.updateProduct(id, productRecordDto);
    }
}
