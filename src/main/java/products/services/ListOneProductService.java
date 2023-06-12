package products.services;

import products.exceptions.RequiredObjectIsNullException;
import products.exceptions.ResourceNotFoundException;
import products.models.ProductModel;
import products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ListOneProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<Object> getOneProduct(UUID id) {
        Optional<ProductModel> productO = productRepository.findById(id);
        if (productO.isEmpty()) {
            throw new ResourceNotFoundException("Product Not Found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productO.get());
    }
}
