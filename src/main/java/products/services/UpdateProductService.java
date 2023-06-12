package products.services;

import products.dtos.ProductRecordDto;
import products.exceptions.RequiredObjectIsNullException;
import products.exceptions.ResourceNotFoundException;
import products.models.ProductModel;
import products.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<Object> updateProduct(UUID id, ProductRecordDto productRecordDto) {
        Optional<ProductModel> productO = productRepository.findById(id);

        if (productRecordDto == null) throw new RequiredObjectIsNullException();
        if (productO.isEmpty()) {
            throw new ResourceNotFoundException("Product Not Found");
        }

        var productModel = productO.get();

        if (productRecordDto.name() == null) {
            productModel.setName(productModel.getName());
        }

        productModel.setUpdatedAtAt(new Date());

        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }
}
