package id.co.bca.funtravel.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer idProduct;
    private String productName;
    private String type;
    private String destination;
    private Date startDate;
    private Date endDate;
    private Integer days;
    private Boolean transport;
    private Boolean hotel;
    private Double price;
    private Double discount;
    private String description;

}
