package id.co.bca.funtravel.product.model.entity;

import jakarta.persistence.*;
import org.springframework.data.relational.core.sql.In;

import java.sql.Timestamp;

public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFacility;

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
