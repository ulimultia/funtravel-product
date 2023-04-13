package id.co.bca.funtravel.product.model.dto;

import id.co.bca.funtravel.product.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDTO {
    private Integer idProductDetail;
    private String place;
    private String description;
    private Product product;
}
