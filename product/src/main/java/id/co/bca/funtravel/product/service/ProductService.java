package id.co.bca.funtravel.product.service;

import id.co.bca.funtravel.product.model.dto.ProductDTO;
import id.co.bca.funtravel.product.model.entity.Product;
import id.co.bca.funtravel.product.repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService{
    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        product.setIsDeleted(Boolean.FALSE);
        product.setCreatedDate(Timestamp.from(Instant.now()));
        product.setUpdatedDate(Timestamp.from(Instant.now()));
        productRepo.save(product);
        return new ProductDTO(product.getIdProduct(), product.getProductName(), product.getType(), product.getDestination(), product.getStartDate(), product.getEndDate(), product.getDays(), product.getTransport(), product.getHotel(), product.getPrice(), product.getDiscount(), product.getDescription());
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Product product = productRepo.findByIdProduct(productDTO.getIdProduct());

        if(product != null){
            BeanUtils.copyProperties(productDTO,product);
            product.setUpdatedDate(Timestamp.from(Instant.now()));
            productRepo.save(product);
            return new ProductDTO(product.getIdProduct(), product.getProductName(), product.getType(), product.getDestination(), product.getStartDate(), product.getEndDate(), product.getDays(), product.getTransport(), product.getHotel(), product.getPrice(), product.getDiscount(), product.getDescription());
        }
        else{
            return null;
        }
    }

    //GET ALL PRODUCT (NOT DELETED PRODUCT ONLY)
    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productRepo.findByIsDeleted(Boolean.FALSE);
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products){
            productDTOS.add(new ProductDTO(product.getIdProduct(), product.getProductName(), product.getType(), product.getDestination(), product.getStartDate(), product.getEndDate(),product.getDays(), product.getTransport(), product.getHotel(), product.getPrice(), product.getDiscount(), product.getDescription()));
        }
        return productDTOS;
    }

    //GET PRODUCT BY ID (NOT DELETED PRODUCT ONLY)
    @Override
    public ProductDTO getById(Integer id) {
        Product product = productRepo.findByIdProduct(id);
        if(product == null){
            return null;
        }
        else{
            return new ProductDTO(product.getIdProduct(), product.getProductName(), product.getType(), product.getDestination(), product.getStartDate(), product.getEndDate(), product.getDays(), product.getTransport(), product.getHotel(), product.getPrice(), product.getDiscount(), product.getDescription());
        }
    }

    //SOFT DELETES
    @Override
    public ProductDTO delete(Integer id) {
        Product product = productRepo.findByIdProduct(id);
        if(product != null){
            product.setIsDeleted(Boolean.TRUE);
            productRepo.save(product);
            return new ProductDTO(product.getIdProduct(), product.getProductName(), product.getType(), product.getDestination(), product.getStartDate(), product.getEndDate(), product.getDays(), product.getTransport(), product.getHotel(), product.getPrice(), product.getDiscount(), product.getDescription());
        }
        else{
            return null;
        }
    }
}
