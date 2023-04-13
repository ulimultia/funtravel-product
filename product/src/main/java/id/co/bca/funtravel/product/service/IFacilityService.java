package id.co.bca.funtravel.product.service;

import id.co.bca.funtravel.product.model.dto.FacilityDTO;

import java.util.List;

public interface IFacilityService {
    public FacilityDTO create(FacilityDTO facilityDTO);
    public FacilityDTO update(FacilityDTO facilityDTO);
    public List<FacilityDTO> getAll();
    public FacilityDTO getById(Integer id);
    public FacilityDTO delete(Integer id);
}
