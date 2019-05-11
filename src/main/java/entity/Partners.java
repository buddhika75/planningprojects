/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Windhelm
 */
class Partners {
    private String nameOfAgency;
    private String natureOfIntervention;
    private String currentStatusOfIntervention;
    private boolean isIncludeDevelopmentActivity;

    
    private Partners(String nameOfAgency,String natureOfIntervention, String currentStatusOfIntervention,boolean isIncludeDevelopmentActivity){
        this.nameOfAgency = nameOfAgency;
        this.natureOfIntervention = natureOfIntervention;
        this.currentStatusOfIntervention = currentStatusOfIntervention;
        this.isIncludeDevelopmentActivity = isIncludeDevelopmentActivity;
    }
    /**
     * @return the nameOfAgency
     */
    public String getNameOfAgency() {
        return nameOfAgency;
    }

    /**
     * @param nameOfAgency the nameOfAgency to set
     */
    public void setNameOfAgency(String nameOfAgency) {
        this.nameOfAgency = nameOfAgency;
    }

    /**
     * @return the natureOfIntervention
     */
    public String getNatureOfIntervention() {
        return natureOfIntervention;
    }

    /**
     * @param natureOfIntervention the natureOfIntervention to set
     */
    public void setNatureOfIntervention(String natureOfIntervention) {
        this.natureOfIntervention = natureOfIntervention;
    }

    /**
     * @return the currentStatusOfIntervention
     */
    public String getCurrentStatusOfIntervention() {
        return currentStatusOfIntervention;
    }

    /**
     * @param currentStatusOfIntervention the currentStatusOfIntervention to set
     */
    public void setCurrentStatusOfIntervention(String currentStatusOfIntervention) {
        this.currentStatusOfIntervention = currentStatusOfIntervention;
    }

    /**
     * @return the isIncludeDevelopmentActivity
     */
    public boolean isIsIncludeDevelopmentActivity() {
        return isIncludeDevelopmentActivity;
    }

    /**
     * @param isIncludeDevelopmentActivity the isIncludeDevelopmentActivity to set
     */
    public void setIsIncludeDevelopmentActivity(boolean isIncludeDevelopmentActivity) {
        this.isIncludeDevelopmentActivity = isIncludeDevelopmentActivity;
    }
    
    
}

