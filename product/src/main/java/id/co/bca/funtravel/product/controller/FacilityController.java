package id.co.bca.funtravel.product.controller;

import id.co.bca.funtravel.product.model.dto.FacilityDTO;
import id.co.bca.funtravel.product.model.dto.StatusMessageDTO;
import id.co.bca.funtravel.product.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;

    //ambil semua data fasilitas berdasarkan produknya
    @GetMapping("/all")
    public ResponseEntity<?> getAllFacility(){
        try {
            StatusMessageDTO<List<FacilityDTO>> response = new StatusMessageDTO<>();
            List<FacilityDTO> facilityDTOS = iFacilityService.getAll();
            if(facilityDTOS.size() == 0){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Data fasilitas kosong!");
                response.setData(facilityDTOS);
                return ResponseEntity.badRequest().body(response);
            }
            else {
                response.setStatus(HttpStatus.OK.value());
                response.setMessage("Berhasil!");
                response.setData(facilityDTOS);
                return ResponseEntity.ok().body(response);
            }
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    //Get by id
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getByIdFacility(@PathVariable Integer id) {
        try {
            StatusMessageDTO<FacilityDTO> response = new StatusMessageDTO<>();
            FacilityDTO facilityDTO = iFacilityService.getById(id);
            if (facilityDTO == null) {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Data tidak ditemukan!");
                response.setData(facilityDTO);
                return ResponseEntity.badRequest().body(response);
            }
            else {
                response.setStatus(HttpStatus.OK.value());
                response.setMessage("Data ditemukan!");
                response.setData(facilityDTO);
                return ResponseEntity.ok().body(response);
            }
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addFacility(@RequestBody FacilityDTO facilityDTO) {
        try {
            StatusMessageDTO<FacilityDTO> response = new StatusMessageDTO<>();
            // validasi fields
            if (facilityDTO.getFacilityName().isEmpty() == true) {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Gagal input data! Nama produk kosong!");
                response.setData(facilityDTO);
                return ResponseEntity.badRequest().body(response);
            }
            FacilityDTO newFacilityDTO = iFacilityService.create(facilityDTO);
            response.setStatus(HttpStatus.CREATED.value());
            response.setMessage("Data berhasil diinputkan!");
            response.setData(newFacilityDTO);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<?> updateFacility(@RequestBody FacilityDTO facilityDTO){
        try {
            StatusMessageDTO<FacilityDTO> response = new StatusMessageDTO<>();
            FacilityDTO newFacilityDTO = iFacilityService.update(facilityDTO);
            if(newFacilityDTO == null){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Gagal update data!");
                response.setData(facilityDTO);
                return ResponseEntity.badRequest().body(response);
            }
            else{
                response.setStatus(HttpStatus.OK.value());
                response.setMessage("Berhasil update data!");
                response.setData(newFacilityDTO);
                return ResponseEntity.ok().body(response);
            }


        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        try {
            StatusMessageDTO<FacilityDTO> response = new StatusMessageDTO<>();
            FacilityDTO newFacilityDTO = iFacilityService.delete(id);
            if (newFacilityDTO == null){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Gagal update data!");
                response.setData(null);
                return ResponseEntity.badRequest().body(response);
            }
            else {
                response.setStatus(HttpStatus.OK.value());
                response.setMessage("Berhasil hapus data!");
                response.setData(newFacilityDTO);
                return ResponseEntity.ok().body(response);
            }
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
