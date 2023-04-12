package id.co.bca.funtravel.product.model.dto;

import id.co.bca.funtravel.product.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDTO {
    private Integer idFacility;
    private String facilityName;
    private String description;
    private Integer isDeleted;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    private Product product;
}
