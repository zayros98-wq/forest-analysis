package com.forest.forest_analysis.repository;

import com.forest.forest_analysis.entity.Analysis;
import com.forest.forest_analysis.entity.AnalysisId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnalysisRepository extends JpaRepository<Analysis, AnalysisId> {

    List<Analysis> findByIdDistrictAndIdYear(String district, int year);

    List<Analysis> findByIdDistrict(String district);
}
