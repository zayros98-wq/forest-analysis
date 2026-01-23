package com.forest.forest_analysis.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AnalysisId implements Serializable {

    private String district;
    private int year;

    public AnalysisId() {}

    public AnalysisId(String district, int year) {
        this.district = district;
        this.year = year;
    }

    // getters & setters
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
