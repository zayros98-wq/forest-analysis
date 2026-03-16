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
        // This ensures the data has the "id" label your HTML needs
        return analysisRepository.findByIdDistrictIgnoreCase(districtId);
    }

    @GetMapping("/district/{district}/year/{year}")
    public List<Analysis> getByDistrictAndYear(
            @PathVariable String district,
            @PathVariable int year) {
        return analysisRepository.findByIdDistrictIgnoreCaseAndIdYear(district, year);
    }
}