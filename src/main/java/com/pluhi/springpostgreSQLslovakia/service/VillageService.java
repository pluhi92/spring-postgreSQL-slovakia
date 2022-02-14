package com.pluhi.springpostgreSQLslovakia.service;

import com.pluhi.springpostgreSQLslovakia.model.Village;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VillageService {
    List<Village> getAllVillages();
    Village getVillageById(long id);
    void saveVillage(Village village);
    Page<Village> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
