/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divudi.entity;

import java.util.Map;

/**
 *
 * @author Windhelm
 */
class FinancialRevenueForecast {
    private String component;
    private Map<Integer,Double> years;

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Map<Integer,Double> getYears() {
        return years;
    }

    public void setYears(Map<Integer,Double> years) {
        this.years = years;
    }
    
    
}
