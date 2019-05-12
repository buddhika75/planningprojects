/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.Lob;

/**
 *
 * @author Windhelm
 */
class ProjectOutcome {
    private int outcomeNo;
    @Lob
    private String outcome;
    @Lob
    private String indicatorOrKPI;
    
    private String unitOfMeasure;
    private String sourceOfData;
    private String baselineData;
    

    private List<YearData> targets;

    public int getOutcomeNo() {
        return outcomeNo;
    }

    public void setOutcomeNo(int outcomeNo) {
        this.outcomeNo = outcomeNo;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getIndicatorOrKPI() {
        return indicatorOrKPI;
    }

    public void setIndicatorOrKPI(String indicatorOrKPI) {
        this.indicatorOrKPI = indicatorOrKPI;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getSourceOfData() {
        return sourceOfData;
    }

    public void setSourceOfData(String sourceOfData) {
        this.sourceOfData = sourceOfData;
    }

    public String getBaselineData() {
        return baselineData;
    }

    public void setBaselineData(String baselineData) {
        this.baselineData = baselineData;
    }

    public List<YearData> getTargets() {
        return targets;
    }

    public void setTargets(List<YearData> targets) {
        this.targets = targets;
    }
    
    
    
}
