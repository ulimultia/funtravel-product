package id.co.bca.funtravel.product.service;

import id.co.bca.funtravel.product.model.dto.ProductDTO;
import id.co.bca.funtravel.product.model.entity.Product;
import id.co.bca.funtravel.product.repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService implements IProductService{
    @Autowired
    private ProductRepo productRepo;

    //Tambah product baru
    @Override
    public ProductDTO create(ProductDTO productDTO) {
        Product product = new Product();
        //set value
        product.setProductName(productDTO.getProductName());
        product.setType(productDTO.getType());
        product.setPrice(productDTO.getPrice());
        product.setDestination(productDTO.getDestination());
        product.setCreatedDate(Timestamp.from(Instant.now()));
        product.setUpdatedDate(Timestamp.from(Instant.now()));
        product.setIsDeleted(0);
        productRepo.save(product);
        return new ProductDTO(product.getIdProduct(), product.getProductName(), product.getDestination(), product.getPrice(), product.getType());
    }

    //Update product
    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Product product = productRepo.findByIdProduct(productDTO.getIdProduct());

        if(product != null){
            product.setProductName(productDTO.getProductName());
            product.setType(product.getType());
            product.setPrice(product.getPrice());
            product.setDestination(productDTO.getDestination());
            product.setUpdatedDate(Timestamp.from(Instant.now()));
            productRepo.save(product);
            return new ProductDTO(product.getIdProduct(), product.getProductName(), product.getDestination(), product.getPrice(), product.getType());
        }
        else{
            return null;
        }

    }

    //Tampil semua produk yang belum berstatus dihapus
    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productRepo.findByIsDeleted(0);
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products){
            productDTOS.add(new ProductDTO(product.getIdProduct(), product.getProductName(), product.getDestination(), product.getPrice(), product.getType()));
        }
        return productDTOS;
    }

    //Tampil product berdasarkan id
    @Override
    public ProductDTO getById(Integer id) {
        Product product = productRepo.findByIdProduct(id);
        if(product == null){
            return null;
        }
        else{
            return new ProductDTO(product.getIdProduct(), product.getProductName(), product.getDestination(), product.getPrice(), product.getType());
        }
    }

    //soft delete
    @Override
    public ProductDTO delete(Integer id) {
        Product product = productRepo.findByIdProduct(id);
        if(product != null){
            product.setIsDeleted(1);
            productRepo.save(product);
            return new ProductDTO(product.getIdProduct(), product.getProductName(), product.getDestination(), product.getPrice(), product.getType());
        }
        else{
            return null;
        }
    }
}
