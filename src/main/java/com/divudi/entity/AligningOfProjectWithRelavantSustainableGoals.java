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
class AligningOfProjectWithRelavantSustainableGoals {
    
    private String sustainableDevelopmentGoal;
    private String sustainabelDevelopmentTarget;
    private boolean directlyRelated;
    private boolean indirectlyRelated;
    private String measurableIndicators;
    private double expectedContributionAchievement;

    public String getSustainableDevelopmentGoal() {
        return sustainableDevelopmentGoal;
    }

    public void setSustainableDevelopmentGoal(String sustainableDevelopmentGoal) {
        this.sustainableDevelopmentGoal = sustainableDevelopmentGoal;
    }

    public String getSustainabelDevelopmentTarget() {
        return sustainabelDevelopmentTarget;
    }

    public void setSustainabelDevelopmentTarget(String sustainabelDevelopmentTarget) {
        this.sustainabelDevelopmentTarget = sustainabelDevelopmentTarget;
    }

    public boolean isDirectlyRelated() {
        return directlyRelated;
    }

    public void setDirectlyRelated(boolean directlyRelated) {
        this.directlyRelated = directlyRelated;
    }

    public boolean isIndirectlyRelated() {
        return indirectlyRelated;
    }

    public void setIndirectlyRelated(boolean indirectlyRelated) {
        this.indirectlyRelated = indirectlyRelated;
    }

    public String getMeasurableIndicators() {
        return measurableIndicators;
    }

    public void setMeasurableIndicators(String measurableIndicators) {
        this.measurableIndicators = measurableIndicators;
    }

    public double getExpectedContributionAchievement() {
        return expectedContributionAchievement;
    }

    public void setExpectedContributionAchievement(double expectedContributionAchievement) {
        this.expectedContributionAchievement = expectedContributionAchievement;
    }
    
    
}
