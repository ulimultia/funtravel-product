package id.co.bca.funtravel.product.service;

import id.co.bca.funtravel.product.model.dto.ProductDTO;
import id.co.bca.funtravel.product.model.dto.ProductDetailDTO;
import id.co.bca.funtravel.product.model.entity.Product;
import id.co.bca.funtravel.product.model.entity.ProductDetail;
import id.co.bca.funtravel.product.repository.ProductDetailRepo;
import id.co.bca.funtravel.product.repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class ProductDetailService implements IProductDetailService{

    @Autowired
    private ProductDetailRepo productDetailRepo;

    @Autowired
    ProductRepo productRepo;

    @Override
    public ProductDetailDTO create(ProductDetailDTO productDetailDTO) {
        ProductDetail productDetail = new ProductDetail();

        Product product = productRepo.findByIdProduct(productDetailDTO.getProduct().getIdProduct());
        ProductDTO newProductDTO = new ProductDTO();
        BeanUtils.copyProperties(product,newProductDTO);

        productDetail.setPlace(productDetailDTO.getPlace());
        productDetail.setDescription(productDetailDTO.getDescription());
        productDetail.setProduct(productDetailDTO.getProduct());
        productDetail.setIdDeleted(0);
        productDetail.setCreatedDate(Timestamp.from(Instant.now()));
        productDetail.setUpdatedDate(Timestamp.from(Instant.now()));
        productDetailRepo.save(productDetail);


        return new ProductDetailDTO(productDetail.getIdProductDetail(), productDetail.getPlace(), productDetail.getDescription(), product);
    }

    @Override
    public ProductDetailDTO update(ProductDetailDTO productDetailDTO) {
        return null;
    }

    @Override
    public List<ProductDetailDTO> getAll() {
        return null;
    }

    @Override
    public ProductDetailDTO getById(Integer id) {
        return null;
    }

    @Override
    public ProductDetailDTO delete(Integer id) {
        return null;
    }
}
