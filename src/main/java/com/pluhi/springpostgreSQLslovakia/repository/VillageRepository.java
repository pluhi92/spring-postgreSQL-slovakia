package com.pluhi.springpostgreSQLslovakia.repository;

import com.pluhi.springpostgreSQLslovakia.model.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepository extends JpaRepository<Village, Long> {
}
