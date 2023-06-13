package products.controllers;

import org.springframework.web.bind.annotation.RequestParam;
import products.models.ProductModel;
import products.services.ListProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListProductsController {
    @Autowired
    ListProductsService listProductsService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts( @RequestParam(required = false, defaultValue = "0") int page,
                                                              @RequestParam(required = false, defaultValue = "50") int size
                                                             ) {
        List<ProductModel> productsList = listProductsService.getAllProducts(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(productsList);
    }
}
