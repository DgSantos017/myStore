package products.services;

import products.models.ProductModel;
import products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProductsService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAllProducts() {
        List<ProductModel> productsList = productRepository.findAll();
        return productsList;
    }
}
