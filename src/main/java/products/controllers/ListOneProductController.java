package products.controllers;

import products.services.ListOneProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.UUID;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListOneProductController {
    @Autowired
    ListOneProductService listOneProductService;

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id) {
        return listOneProductService.getOneProduct(id);
    }
}
