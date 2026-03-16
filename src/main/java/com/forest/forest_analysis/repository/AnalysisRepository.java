package com.forest.forest_analysis.repository;

import com.forest.forest_analysis.entity.Analysis;
import com.forest.forest_analysis.entity.AnalysisId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AnalysisRepository extends JpaRepository<Analysis, AnalysisId> {

    // These methods return full objects so your HTML can read 'it.id.year'
    List<Analysis> findByIdDistrictIgnoreCase(String district);

    List<Analysis> findByIdDistrictIgnoreCaseAndIdYear(String district, int year);
}