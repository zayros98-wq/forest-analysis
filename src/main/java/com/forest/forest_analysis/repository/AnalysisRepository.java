package com.forest.forest_analysis.repository;

import com.forest.forest_analysis.entity.Analysis;
import com.forest.forest_analysis.entity.AnalysisId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AnalysisRepository extends JpaRepository<Analysis, AnalysisId> {

    List<Analysis> findByIdDistrictAndIdYear(String district, int year);

    // This query uses the correct name 'forestPercentage' from your Analysis class
    @Query("SELECT a.id.year, AVG(a.forestPercentage) FROM Analysis a " +
            "WHERE a.id.district = :district " +
            "GROUP BY a.id.year " +
            "ORDER BY a.id.year ASC")
    List<Object[]> findAverageForestCoverageByDistrict(@Param("district") String district);
}