package id.co.bca.funtravel.product.controller;

import id.co.bca.funtravel.product.service.IProductService;
import id.co.bca.funtravel.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllProduct(){
        try {
            return null;
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }
}
