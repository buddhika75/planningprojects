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
public class Area {
    private String province;
    private String district;
    private String city;

    public Area(String province,String district,String city){
        this.province = province;
        this.district = district;
        this.city = city;
    }
    
    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the District
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param District the District to set
     */
    public void setDistrict(String District) {
        this.district = District;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    
}
