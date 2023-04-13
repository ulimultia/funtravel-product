package id.co.bca.funtravel.product.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFacility;

    @Column
    private Integer idProduct;

    @Column
    private String facilityName;

    @Column
    private String description;

    @Column
    private Integer isDeleted;

    @Basic
    private Timestamp createdDate;

    @Basic
    private Timestamp updatedDate;
}
