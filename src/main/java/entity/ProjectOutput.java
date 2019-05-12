/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author Windhelm
 */
class ProjectOutput {
    private int outputNo;
    private String output;
    private String indicatorOrKPI;
    private String unitOfMeasure;
    private String sourceOfData;
    private String baselineData;
    private List<YearData> targets;

    /**
     * @return the output
     */
    public String getOutput() {
        return output;
    }

    /**
     * @param output the output to set
     */
    public void setOutput(String output) {
        this.output = output;
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

    public List<YearData> getTargets() {
        return targets;
    }

    public void setTargets(List<YearData> targets) {
        this.targets = targets;
    }

    public int getOutputNo() {
        return outputNo;
    }

    public void setOutputNo(int outputNo) {
        this.outputNo = outputNo;
    }

    
    
    
   
   }
