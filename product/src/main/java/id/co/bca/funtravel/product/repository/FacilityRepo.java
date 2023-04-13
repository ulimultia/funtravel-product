package id.co.bca.funtravel.product.repository;

import id.co.bca.funtravel.product.model.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FacilityRepo extends JpaRepository<Facility, Integer> {
    //cari semua data yang berdasarkan status is_deleted
    public List<Facility> findByIsDeleted(Integer isDeleted);

    @Query(value = "select * from facility where is_deleted = 0 and id_facility = ?", nativeQuery = true)
    public Facility findByIdFacility(Integer id);

}
