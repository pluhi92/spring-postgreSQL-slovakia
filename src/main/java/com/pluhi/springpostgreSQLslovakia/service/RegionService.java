package com.pluhi.springpostgreSQLslovakia.service;

import com.pluhi.springpostgreSQLslovakia.model.Region;
import org.springframework.data.domain.Page;
import java.util.List;

public interface RegionService {
    List<Region> getAllRegions();

    Region getRegionById(Long id);

    Page<Region> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
