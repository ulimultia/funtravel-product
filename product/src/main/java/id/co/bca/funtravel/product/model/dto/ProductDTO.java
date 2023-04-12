package id.co.bca.funtravel.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer idProduct;
    private String productName;
    private String destination;
    private Float price;
    private String type;
}
