package products.controllers;

import products.dtos.ProductRecordDto;
import products.services.UpdateProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.UUID;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateProductController {
    @Autowired
    UpdateProductService updateProductService;

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid ProductRecordDto productRecordDto) {
        return updateProductService.updateProduct(id, productRecordDto);
    }
}
