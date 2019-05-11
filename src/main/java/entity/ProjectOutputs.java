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
class ProjectOutputs {
    private int OutputNo;
    private String outcome;
    private String indicatorOrKPI;
    private String unitOfMeasure;
    private String sourceOfData;
    private String baselineData;
    private int year;
    private String[] targets;

    /**
     * @return the outcome
     */
    public String getOutcome() {
        return outcome;
    }

    /**
     * @param outcome the outcome to set
     */
    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    /**
     * @return the indicatorOrKPI
     */
    public String getIndicatorOrKPI() {
        return indicatorOrKPI;
    }

    /**
     * @param indicatorOrKPI the indicatorOrKPI to set
     */
    public void setIndicatorOrKPI(String indicatorOrKPI) {
        this.indicatorOrKPI = indicatorOrKPI;
    }

    /**
     * @return the unitOfMeasure
     */
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * @param unitOfMeasure the unitOfMeasure to set
     */
    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    /**
     * @return the sourceOfData
     */
    public String getSourceOfData() {
        return sourceOfData;
    }

    /**
     * @param sourceOfData the sourceOfData to set
     */
    public void setSourceOfData(String sourceOfData) {
        this.sourceOfData = sourceOfData;
    }

    /**
     * @return the baselineData
     */
    public String getBaselineData() {
        return baselineData;
    }

    /**
     * @param baselineData the baselineData to set
     */
    public void setBaselineData(String baselineData) {
        this.baselineData = baselineData;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the targets
     */
    public String[] getTargets() {
        return targets;
    }

    /**
     * @param targets the targets to set
     */
    public void setTargets(String[] targets) {
        this.targets = targets;
    }
   }
