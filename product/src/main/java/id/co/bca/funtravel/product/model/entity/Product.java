package id.co.bca.funtravel.product.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue (strategy  = GenerationType.IDENTITY)
    private Integer idProduct;

    @Column
    private String productName;

    @Column
    private String destination;

    @Column(nullable = false)
    private Float price;

    @Column
    private String type;

    @Column
    private Integer isDeleted;

    @Basic
    private Timestamp createdDate;

    @Basic
    private Timestamp updatedDate;

}
