package products.controllers;

import products.services.DeleteProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.UUID;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteProductController {
    @Autowired
    DeleteProductService deleteProductService;

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id) {
        return deleteProductService.deleteProduct(id);
    }
}
