package id.co.bca.funtravel.product.service;

import id.co.bca.funtravel.product.model.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    public ProductDTO create(ProductDTO productDTO);
    public ProductDTO update(ProductDTO productDTO);
    public List<ProductDTO> getAll();
    public ProductDTO getById(Integer id);
    public ProductDTO delete(Integer id);

}
