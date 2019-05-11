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
public class ProjectBudgetDetailsOfActivities {
    private String activity;
    private double cost;
    private int noOfUnits;
    private double unitCost;
    private double strandradCostNationl;
    private double strandradCostInternational;

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(int noOfUnits) {
        this.noOfUnits = noOfUnits;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getStrandradCostNationl() {
        return strandradCostNationl;
    }

    public void setStrandradCostNationl(double strandradCostNationl) {
        this.strandradCostNationl = strandradCostNationl;
    }

    public double getStrandradCostInternational() {
        return strandradCostInternational;
    }

    public void setStrandradCostInternational(double strandradCostInternational) {
        this.strandradCostInternational = strandradCostInternational;
    }
    
    
}
