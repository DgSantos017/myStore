package products.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.Date;

@Entity
@Table(name="TB_PRODUCTS")
public class ProductModel extends RepresentationModel<ProductModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idProduct;
    private String name;
    private String description;
    private BigDecimal value;
    private Date createdAt;
    private Date updatedAt;

    public UUID getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getCreatedAt() {
        return new Date();
    }
    public void setCreatedAt(Date createdAt) {this.createdAt = createdAt; }

    public Date getUpdatedAtAt() {
        return new Date();
    }
    public void setUpdatedAtAt(Date updatedAt) {this.updatedAt = updatedAt; }

}
