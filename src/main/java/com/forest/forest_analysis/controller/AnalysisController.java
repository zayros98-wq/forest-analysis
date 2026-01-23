package com.forest.forest_analysis.controller;

import com.forest.forest_analysis.entity.Analysis;
import com.forest.forest_analysis.repository.AnalysisRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analysis")
@CrossOrigin(origins = "*") // allows frontend access
public class AnalysisController {

    private final AnalysisRepository analysisRepository;

    public AnalysisController(AnalysisRepository analysisRepository) {
        this.analysisRepository = analysisRepository;
    }

    // 1️⃣ Get ALL records
    @GetMapping("/all")
    public List<Analysis> getAllData() {
        return analysisRepository.findAll();
    }

    // 2️⃣ Get data by district
    @GetMapping("/district/{district}")
    public List<Analysis> getByDistrict(@PathVariable String district) {
        return analysisRepository.findByIdDistrict(district);
    }

    // 3️⃣ Get data by district + year
    @GetMapping("/district/{district}/year/{year}")
    public List<Analysis> getByDistrictAndYear(
            @PathVariable String district,
            @PathVariable int year) {
        return analysisRepository.findByIdDistrictAndIdYear(district, year);
    }
}
