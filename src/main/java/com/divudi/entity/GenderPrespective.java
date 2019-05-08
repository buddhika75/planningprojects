/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divudi.entity;

import java.util.List;

/**
 *
 * @author Windhelm
 */
class GenderPrespective {
    private boolean isIdentifiedGenderGaps;
    private String genderGapDescription;
    private List<String> genderImbalance;

    public boolean isIsIdentifiedGenderGaps() {
        return isIdentifiedGenderGaps;
    }

    public void setIsIdentifiedGenderGaps(boolean isIdentifiedGenderGaps) {
        this.isIdentifiedGenderGaps = isIdentifiedGenderGaps;
    }

    public String getGenderGapDescription() {
        return genderGapDescription;
    }

    public void setGenderGapDescription(String genderGapDescription) {
        this.genderGapDescription = genderGapDescription;
    }

    public List<String> getGenderImbalance() {
        return genderImbalance;
    }

    public void setGenderImbalance(List<String> genderImbalance) {
        this.genderImbalance = genderImbalance;
    }
}
