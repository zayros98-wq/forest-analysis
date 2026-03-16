package com.forest.forest_analysis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AnalysisId implements Serializable {

    @Column(name = "district") // Matches your screenshot
    private String district;

    @Column(name = "Year") // Matches your screenshot (Capital Y)
    private int year;

    public AnalysisId() {}
    public AnalysisId(String district, int year) { this.district = district; this.year = year; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnalysisId that = (AnalysisId) o;
        return year == that.year && Objects.equals(district, that.district);
    }
    @Override
    public int hashCode() { return Objects.hash(district, year); }
}