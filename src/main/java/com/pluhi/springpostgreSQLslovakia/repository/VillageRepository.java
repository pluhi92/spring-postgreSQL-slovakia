package com.pluhi.springpostgreSQLslovakia.repository;

import com.pluhi.springpostgreSQLslovakia.model.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VillageRepository extends JpaRepository<Village, Long> {

    @Query(value = "SELECT * FROM village v WHERE v.fullname LIKE concat('%', :keyword, '%') ORDER BY id_village asc", nativeQuery = true)
    List<Village> findAll(String keyword);
}
