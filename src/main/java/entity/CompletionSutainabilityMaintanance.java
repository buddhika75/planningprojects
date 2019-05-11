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
class CompletionSutainabilityMaintanance {
    private String operationOrSustainabilityType;
    private boolean coveredByProject;
    private String responsibleAgency;

    public String getOperationOrSustainabilityType() {
        return operationOrSustainabilityType;
    }

    public void setOperationOrSustainabilityType(String operationOrSustainabilityType) {
        this.operationOrSustainabilityType = operationOrSustainabilityType;
    }

    public boolean isCoveredByProject() {
        return coveredByProject;
    }

    public void setCoveredByProject(boolean coveredByProject) {
        this.coveredByProject = coveredByProject;
    }

    public String getResponsibleAgency() {
        return responsibleAgency;
    }

    public void setResponsibleAgency(String responsibleAgency) {
        this.responsibleAgency = responsibleAgency;
    }
    
}
