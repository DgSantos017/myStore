package products.services;

import org.springframework.data.domain.Page;
import products.controllers.ListOneProductController;
import products.models.ProductModel;
import products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ListProductsService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductModel> productPage = productRepository.findAll(pageable);
        if(!productPage.isEmpty()) {
            for(ProductModel product : productPage) {
                UUID id = product.getIdProduct();
                product.add(linkTo(methodOn(ListOneProductController.class).getOneProduct(id)).withSelfRel());
            }
        }
        return productPage.getContent();
    }
}
