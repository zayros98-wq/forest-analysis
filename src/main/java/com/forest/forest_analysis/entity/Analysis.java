package com.forest.forest_analysis.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "analysis")
public class Analysis {

    @EmbeddedId
    private AnalysisId id;

    @Column(name = "Forest_Percentage")
    private float forestPercentage;

    @Column(name = "Water_Percentage")
    private float waterPercentage;

    @Column(name = "Land_percentage")
    private float landPercentage;

    // getters & setters
    public AnalysisId getId() {
        return id;
    }

    public void setId(AnalysisId id) {
        this.id = id;
    }

    public float getForestPercentage() {
        return forestPercentage;
    }

    public void setForestPercentage(float forestPercentage) {
        this.forestPercentage = forestPercentage;
    }

    public float getWaterPercentage() {
        return waterPercentage;
    }

    public void setWaterPercentage(float waterPercentage) {
        this.waterPercentage = waterPercentage;
    }

    public float getLandPercentage() {
        return landPercentage;
    }

    public void setLandPercentage(float landPercentage) {
        this.landPercentage = landPercentage;
    }
}
