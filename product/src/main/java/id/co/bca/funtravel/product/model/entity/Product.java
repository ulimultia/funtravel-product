package id.co.bca.funtravel.product.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
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
    private String type;
    @Column
    private String destination;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private Integer days;
    @Column
    private Boolean transport;
    @Column
    private Boolean hotel;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Double discount;
    @Column
    private String description;
    @Column
    private Boolean isDeleted;
    @Basic
    private Timestamp createdDate;
    @Basic
    private Timestamp updatedDate;

}
