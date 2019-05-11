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
class Benificiaries {
    private String type;
    private int noOfbenificiaries;
    private String genderRatio;

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the noOfbenificiaries
     */
    public int getNoOfbenificiaries() {
        return noOfbenificiaries;
    }

    /**
     * @param noOfbenificiaries the noOfbenificiaries to set
     */
    public void setNoOfbenificiaries(int noOfbenificiaries) {
        this.noOfbenificiaries = noOfbenificiaries;
    }

    /**
     * @return the genderRatio
     */
    public String getGenderRatio() {
        return genderRatio;
    }

    /**
     * @param genderRatio the genderRatio to set
     */
    public void setGenderRatio(String genderRatio) {
        this.genderRatio = genderRatio;
    }
    
    
}
