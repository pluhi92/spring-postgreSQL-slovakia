package com.pluhi.springpostgreSQLslovakia.service;

import com.pluhi.springpostgreSQLslovakia.model.Village;
import com.pluhi.springpostgreSQLslovakia.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VillageServiceImpl implements VillageService {

    @Autowired
    private VillageRepository villageRepository;

    @Override
    public List<Village> getAllVillages() {
        return villageRepository.findAll();
    }

    @Override
    public Village getVillageById(long id) {
        Optional<Village> optional = villageRepository.findById(id);
        Village village = null;
        if (optional.isPresent()) {
            village = optional.get();
        } else {
            throw new RuntimeException(" Village not found for id :: " + id);
        }
        return village;
    }

    @Override
    public void saveVillage(Village village) {
        this.villageRepository.save(village);
    }

    @Override
    public Page<Village> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.villageRepository.findAll(pageable);
    }
}

