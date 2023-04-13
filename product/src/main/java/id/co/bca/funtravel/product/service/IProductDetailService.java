package id.co.bca.funtravel.product.service;


import id.co.bca.funtravel.product.model.dto.ProductDetailDTO;

import java.util.List;

public interface IProductDetailService {
    public ProductDetailDTO create(ProductDetailDTO productDetailDTO);
    public ProductDetailDTO update(ProductDetailDTO productDetailDTO);
    public List<ProductDetailDTO> getAll();
    public ProductDetailDTO getById(Integer id);
    public ProductDetailDTO delete(Integer id);
}
