package id.co.bca.funtravel.product.controller;

import id.co.bca.funtravel.product.model.dto.ProductDTO;
import id.co.bca.funtravel.product.model.dto.StatusMessageDTO;
import id.co.bca.funtravel.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
//@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllProduct(){
        try {
            StatusMessageDTO<List<ProductDTO>> response = new StatusMessageDTO<>();
            List<ProductDTO> productDTOS = iProductService.getAll();
            if (productDTOS.size() == 0){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Data produk kosong!");
                response.setData(productDTOS);
                return ResponseEntity.badRequest().body(response);
            }
            else{
                response.setStatus(HttpStatus.OK.value());
                response.setMessage("Berhasil!");
                response.setData(productDTOS);
                return ResponseEntity.ok().body(response);
            }
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    //get data by id
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getByIdProduct(@PathVariable Integer id) {
        try {
            StatusMessageDTO<ProductDTO> response = new StatusMessageDTO<>();
            ProductDTO productDTO = iProductService.getById(id);
            if (productDTO == null){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Data tidak ditemukan!");
                response.setData(productDTO);
                return ResponseEntity.badRequest().body(response);
            }
            else{
                response.setStatus(HttpStatus.OK.value());
                response.setMessage("Data ditemukan!");
                response.setData(productDTO);
                return ResponseEntity.ok().body(response);
            }
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    //add product
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO){
        try {
            StatusMessageDTO<ProductDTO> response = new StatusMessageDTO<>();
            // validasi fields
            if(productDTO.getProductName().isEmpty() == true){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Gagal input data! Nama produk kosong!");
                response.setData(productDTO);
                return ResponseEntity.badRequest().body(response);
            }
            ProductDTO newProductDTO = iProductService.create(productDTO);
            response.setStatus(HttpStatus.CREATED.value());
            response.setMessage("Data berhasil diinputkan!");
            response.setData(newProductDTO);
            return ResponseEntity.ok().body(response);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO){
        try {
            StatusMessageDTO<ProductDTO> response = new StatusMessageDTO<>();
            //validasi
            //[.....]
            ProductDTO newProductDTO = iProductService.update(productDTO);
            if(newProductDTO == null){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Gagal update data!");
                response.setData(productDTO);
                return ResponseEntity.badRequest().body(response);
            }
            else{
                response.setStatus(HttpStatus.OK.value());
                response.setMessage("Berhasil update data!");
                response.setData(productDTO);
                return ResponseEntity.ok().body(response);
            }
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        try {
            StatusMessageDTO<ProductDTO> response = new StatusMessageDTO<>();
            ProductDTO productDTO = iProductService.delete(id);
            if (productDTO == null){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Gagal update data!");
                response.setData(productDTO);
                return ResponseEntity.badRequest().body(response);
            }
            else {
                response.setStatus(HttpStatus.OK.value());
                response.setMessage("Berhasil hapus data!");
                response.setData(productDTO);
                return ResponseEntity.ok().body(response);
            }
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
