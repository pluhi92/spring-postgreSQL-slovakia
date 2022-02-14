package com.pluhi.springpostgreSQLslovakia.service;

import com.pluhi.springpostgreSQLslovakia.model.District;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DistrictService {

    List<District> getAllDistricts();

    District getDistrictById(Long id);
    Page<District> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}

