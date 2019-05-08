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
public class FinancingMethod {
    private double domesticFund;
    private double externalSourceLoan;
    private double externalSourceGrant;
    private double proponentFunding;
    private double benificiaryContribution;
    private double coFinancing;
    private String agencyOrSource;
    private double publicPrivatePartnership;
    private double otherFinancialSource;

    public double getDomesticFund() {
        return domesticFund;
    }

    public void setDomesticFund(double domesticFund) {
        this.domesticFund = domesticFund;
    }

    public double getExternalSourceLoan() {
        return externalSourceLoan;
    }

    public void setExternalSourceLoan(double externalSourceLoan) {
        this.externalSourceLoan = externalSourceLoan;
    }

    public double getExternalSourceGrant() {
        return externalSourceGrant;
    }

    public void setExternalSourceGrant(double externalSourceGrant) {
        this.externalSourceGrant = externalSourceGrant;
    }

    public double getProponentFunding() {
        return proponentFunding;
    }

    public void setProponentFunding(double proponentFunding) {
        this.proponentFunding = proponentFunding;
    }

    public double getBenificiaryContribution() {
        return benificiaryContribution;
    }

    public void setBenificiaryContribution(double benificiaryContribution) {
        this.benificiaryContribution = benificiaryContribution;
    }

    public double getCoFinancing() {
        return coFinancing;
    }

    public void setCoFinancing(double coFinancing) {
        this.coFinancing = coFinancing;
    }

    public String getAgencyOrSource() {
        return agencyOrSource;
    }

    public void setAgencyOrSource(String agencyOrSource) {
        this.agencyOrSource = agencyOrSource;
    }

    public double getPublicPrivatePartnership() {
        return publicPrivatePartnership;
    }

    public void setPublicPrivatePartnership(double publicPrivatePartnership) {
        this.publicPrivatePartnership = publicPrivatePartnership;
    }

    public double getOtherFinancialSource() {
        return otherFinancialSource;
    }

    public void setOtherFinancialSource(double otherFinancialSource) {
        this.otherFinancialSource = otherFinancialSource;
    }
    
    
}
