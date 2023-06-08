package products.services;

import products.models.ProductModel;
import products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeleteProductService {
    @Autowired
    private ProductRepository productRepository;


    public ResponseEntity<Object> deleteProduct(UUID id) {
        Optional<ProductModel> productO = productRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        productRepository.delete(productO.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
}
