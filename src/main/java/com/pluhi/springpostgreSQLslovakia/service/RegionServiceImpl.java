package com.pluhi.springpostgreSQLslovakia.service;

import com.pluhi.springpostgreSQLslovakia.model.Region;
import com.pluhi.springpostgreSQLslovakia.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    @Override
    public Region getRegionById(Long id) {
        Optional<Region> optional = regionRepository.findById(id);
        Region region = null;
        if (optional.isPresent()) {
            region = optional.get();
        } else {
            throw new RuntimeException(" Region not found for id :: " + id);
        }
        return region;
    }

    @Override
    public Page<Region> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.regionRepository.findAll(pageable);
    }
}


