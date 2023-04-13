package id.co.bca.funtravel.product.service;

import id.co.bca.funtravel.product.model.dto.FacilityDTO;
import id.co.bca.funtravel.product.model.dto.ProductDTO;
import id.co.bca.funtravel.product.model.entity.Facility;
import id.co.bca.funtravel.product.model.entity.Product;
import id.co.bca.funtravel.product.repository.FacilityRepo;
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
public class FacilityService implements IFacilityService {
    @Autowired
    private FacilityRepo facilityRepo;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public FacilityDTO create(FacilityDTO facilityDTO) {
        Facility facility = new Facility();

        //ambil id product dari DTO facility

        Product product = productRepo.findByIdProduct(facilityDTO.getProductDTO().getIdProduct());
        ProductDTO newProductDTO = new ProductDTO();
        BeanUtils.copyProperties(product,newProductDTO);

        facility.setFacilityName(facilityDTO.getFacilityName());
        facility.setDescription(facilityDTO.getDescription());
        facility.setIdProduct(product.getIdProduct());
        facility.setIsDeleted(0);
        facility.setCreatedDate(Timestamp.from(Instant.now()));
        facility.setUpdatedDate(Timestamp.from(Instant.now()));
        facilityRepo.save(facility);
        return new FacilityDTO(facility.getIdFacility(), facility.getFacilityName(), facility.getDescription(), newProductDTO);
    }

    @Override
    public FacilityDTO update(FacilityDTO facilityDTO) {
        Facility facility = facilityRepo.findByIdFacility(facilityDTO.getIdFacility());

        if(facility != null){
            Product product = productRepo.findByIdProduct(facility.getIdProduct());
            ProductDTO newProductDTO = new ProductDTO();
            BeanUtils.copyProperties(product,newProductDTO);

            facility.setFacilityName(facilityDTO.getFacilityName());
            facility.setDescription(facilityDTO.getDescription());
            facility.setUpdatedDate(Timestamp.from(Instant.now()));
            facilityRepo.save(facility);
            return new FacilityDTO(facility.getIdFacility(), facility.getFacilityName(), facility.getDescription(), newProductDTO);
        }
        else {
            return null;
        }
    }

    @Override
    public List<FacilityDTO> getAll() {
        List<FacilityDTO> facilityDTOS = new ArrayList<>();
        List<Facility> facilities = facilityRepo.findByIsDeleted(0);
        for (Facility facility : facilities) {
            Product product = productRepo.findByIdProduct(facility.getIdProduct());
            ProductDTO newProductDTO = new ProductDTO();
            BeanUtils.copyProperties(product,newProductDTO);
            facilityDTOS.add(new FacilityDTO(facility.getIdFacility(), facility.getFacilityName(), facility.getDescription(), newProductDTO));
        }
        return facilityDTOS;
    }

    @Override
    public FacilityDTO getById(Integer id) {
        Facility facility = facilityRepo.findByIdFacility(id);
        if (facility == null) {
            return null;
        }
        else {
            Product product = productRepo.findByIdProduct(facility.getIdProduct());
            ProductDTO newProductDTO = new ProductDTO();
            BeanUtils.copyProperties(product,newProductDTO);

            return new FacilityDTO(facility.getIdFacility(), facility.getFacilityName(), facility.getDescription(), newProductDTO);
        }
    }

    @Override
    public FacilityDTO delete(Integer id) {
        Facility facility = facilityRepo.findByIdFacility(id);
        Product product = productRepo.findByIdProduct(facility.getIdProduct());
        ProductDTO newProductDTO = new ProductDTO();
        BeanUtils.copyProperties(product,newProductDTO);

        if (facility != null ){
            facility.setIsDeleted(1);
            facility.setUpdatedDate(Timestamp.from(Instant.now()));
            facilityRepo.save(facility);
            return new FacilityDTO(facility.getIdFacility(), facility.getFacilityName(), facility.getDescription(), newProductDTO);
        }
        else {
            return null;
        }
    }
}
