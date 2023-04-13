package id.co.bca.funtravel.product.repository;

import id.co.bca.funtravel.product.model.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDetailRepo extends JpaRepository<ProductDetail, Integer> {
    public List<ProductDetail> findByIsDeleted(Integer isDeleted);

    @Query(value = "select * from product_detail where is_deleted = 0 and id_product_detail = ?", nativeQuery = true)
    public ProductDetail findByIdProductDetail(Integer id);
}
