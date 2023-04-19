package id.co.bca.funtravel.product.repository;

import id.co.bca.funtravel.product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    //tampil semua data yang belum dihapus
    public List<Product> findByIsDeleted(Boolean isDeleted);

    @Query(value = "select * from product where is_deleted = false and id_product = ?", nativeQuery = true)
    public Product findByIdProduct(Integer id);

}
