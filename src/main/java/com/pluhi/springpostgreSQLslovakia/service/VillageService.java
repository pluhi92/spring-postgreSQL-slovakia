package com.pluhi.springpostgreSQLslovakia.service;

import com.pluhi.springpostgreSQLslovakia.model.Village;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VillageService {
    List<Village> getAllVillages(String keyword);
    Village getVillageById(long id);
    void saveVillage(Village village);
    Page<Village> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
