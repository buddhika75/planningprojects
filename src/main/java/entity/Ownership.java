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
public class Ownership {
    private boolean implementingAgency;
    private boolean governmentAgency;
    private boolean isPrivateLand;

    
    public Ownership(boolean implementAgency,boolean governmentAgency,boolean isPrivateLand){
        this.implementingAgency = implementAgency;
        this.governmentAgency = governmentAgency;
        this.isPrivateLand = isPrivateLand;
        
    }
    /**
     * @return the implementingAgency
     */
    public boolean isImplementingAgency() {
        return implementingAgency;
    }

    /**
     * @param implementingAgency the implementingAgency to set
     */
    public void setImplementingAgency(boolean implementingAgency) {
        this.implementingAgency = implementingAgency;
    }

    /**
     * @return the governmentAgency
     */
    public boolean isGovernmentAgency() {
        return governmentAgency;
    }

    /**
     * @param governmentAgency the governmentAgency to set
     */
    public void setGovernmentAgency(boolean governmentAgency) {
        this.governmentAgency = governmentAgency;
    }

    /**
     * @return the isPrivateLand
     */
    public boolean isIsPrivateLand() {
        return isPrivateLand;
    }

    /**
     * @param isPrivateLand the isPrivateLand to set
     */
    public void setIsPrivateLand(boolean isPrivateLand) {
        this.isPrivateLand = isPrivateLand;
    }
    
}
