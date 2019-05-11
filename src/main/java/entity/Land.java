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
public class Land {
    private double totalArea;
    private boolean hasIdentified;
    private Ownership ownership;
    private double costOfLand;

    /**
     * @return the totalArea
     */
    public double getTotalArea() {
        return totalArea;
    }

    /**
     * @param totalArea the totalArea to set
     */
    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    /**
     * @return the hasIdentified
     */
    public boolean isHasIdentified() {
        return hasIdentified;
    }

    /**
     * @param hasIdentified the hasIdentified to set
     */
    public void setHasIdentified(boolean hasIdentified) {
        this.hasIdentified = hasIdentified;
    }

    /**
     * @return the ownership
     */
    public Ownership getOwnership() {
        return ownership;
    }

    /**
     * @param ownership the ownership to set
     */
    public void setOwnership(Ownership ownership) {
        this.ownership = ownership;
    }

    /**
     * @return the costOfLand
     */
    public double getCostOfLand() {
        return costOfLand;
    }

    /**
     * @param costOfLand the costOfLand to set
     */
    public void setCostOfLand(double costOfLand) {
        this.costOfLand = costOfLand;
    }
    
    
}
