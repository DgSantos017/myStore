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
    public ResponseEntity<List<ProductModel>> getAllProducts( @RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size
//                                                              @RequestParam(required = false) Double maxPrice,
//                                                              @RequestParam(required = false) Double minPrice,
//                                                              @RequestParam(required = false) String name,
//                                                              @RequestParam(required = false) String description
                                                             ) {
        List<ProductModel> productsList = listProductsService.getAllProducts(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(productsList);
    }
}
