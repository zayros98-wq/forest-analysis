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

    // This method now correctly returns the averaged data for your chart
    @GetMapping("/district/{district}")
    public List<Object[]> getByDistrict(@PathVariable String district) {
        return analysisRepository.findAverageForestCoverageByDistrict(district);
    }

    @GetMapping("/district/{district}/year/{year}")
    public List<Analysis> getByDistrictAndYear(
            @PathVariable String district,
            @PathVariable int year) {
        return analysisRepository.findByIdDistrictAndIdYear(district, year);
    }
}