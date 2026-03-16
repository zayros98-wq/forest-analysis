package com.forest.forest_analysis.controller;

import com.forest.forest_analysis.entity.Analysis;
import com.forest.forest_analysis.repository.AnalysisRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analysis")
@CrossOrigin(origins = "*")
public class AnalysisController {

    private final AnalysisRepository analysisRepository;

    public AnalysisController(AnalysisRepository analysisRepository) {
        this.analysisRepository = analysisRepository;
    }

    @GetMapping("/all")
    public List<Analysis> getAllData() {
        return analysisRepository.findAll();
    }


    @GetMapping("/district/{districtId}")
    public List<Analysis> getByDistrict(@PathVariable String districtId) {
        // CHANGE THIS: Use findByIdDistrict instead of findAverageForestCoverageByDistrict
        // This sends the full Entity (with .id.year and .forestPercentage) to the HTML
        return analysisRepository.findByIdDistrict(districtId);
    }
    // Inside AnalysisController.java
//    @GetMapping("/district/{districtId}")
//    public List<Analysis> getByDistrict(@PathVariable String districtId) {
//        // Make sure this name matches exactly what you added to the Repository
//        return analysisRepository.findByIdDistrict(districtId);
//    }

    @GetMapping("/district/{district}/year/{year}")
    public List<Analysis> getByDistrictAndYear(
            @PathVariable String district,
            @PathVariable int year) {
        return analysisRepository.findByIdDistrictAndIdYear(district, year);
    }
}