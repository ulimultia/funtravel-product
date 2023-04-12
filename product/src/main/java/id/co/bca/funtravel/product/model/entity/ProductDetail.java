package id.co.bca.funtravel.product.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_detail")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProductDetail;

    @Column
    private String place;

    @Column
    private String description;

    @Column
    private Integer idDeleted;

    @Basic
    private Timestamp createdDate;

    @Basic
    private Timestamp updatedDate;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;
}
