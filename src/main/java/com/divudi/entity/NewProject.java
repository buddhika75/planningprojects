/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divudi.entity;

/**
 *
 * @author Windhelm
 */
public class NewProject {
    
    private String pTitle;
    private String sector;
    private Area Location;
    private Land land;
    private PPreliminaryActivities preliminaryActivities;
    private String projectActivities;
    private Benificiaries benificiaries;
    private String rationaleOfProject;
    

    /**
     * @return the pTitle
     */
    public String getpTitle() {
        return pTitle;
    }

    /**
     * @param pTitle the pTitle to set
     */
    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    /**
     * @return the sector
     */
    public String getSector() {
        return sector;
    }

    /**
     * @param sector the sector to set
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * @return the Location
     */
    public Area getLocation() {
        return Location;
    }

    /**
     * @param Location the Location to set
     */
    public void setLocation(Area Location) {
        this.Location = Location;
    }

    /**
     * @return the land
     */
    public Land getLand() {
        return land;
    }

    /**
     * @param land the land to set
     */
    public void setLand(Land land) {
        this.land = land;
    }

    /**
     * @return the preliminaryActivities
     */
    public PPreliminaryActivities getPreliminaryActivities() {
        return preliminaryActivities;
    }

    /**
     * @param preliminaryActivities the preliminaryActivities to set
     */
    public void setPreliminaryActivities(PPreliminaryActivities preliminaryActivities) {
        this.preliminaryActivities = preliminaryActivities;
    }

    /**
     * @return the projectActivities
     */
    public String getProjectActivities() {
        return projectActivities;
    }

    /**
     * @param projectActivities the projectActivities to set
     */
    public void setProjectActivities(String projectActivities) {
        this.projectActivities = projectActivities;
    }

    /**
     * @return the benificiaries
     */
    public Benificiaries getBenificiaries() {
        return benificiaries;
    }

    /**
     * @param benificiaries the benificiaries to set
     */
    public void setBenificiaries(Benificiaries benificiaries) {
        this.benificiaries = benificiaries;
    }

    /**
     * @return the rationaleOfProject
     */
    public String getRationaleOfProject() {
        return rationaleOfProject;
    }

    /**
     * @param rationaleOfProject the rationaleOfProject to set
     */
    public void setRationaleOfProject(String rationaleOfProject) {
        this.rationaleOfProject = rationaleOfProject;
    }
    
    
}
