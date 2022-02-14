package com.pluhi.springpostgreSQLslovakia.repository;

import com.pluhi.springpostgreSQLslovakia.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
}
