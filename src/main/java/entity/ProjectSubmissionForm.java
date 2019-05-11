/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author buddhika
 */
@Entity
public class ProjectSubmissionForm implements Serializable {

    static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String projectTitle;
    String sector;
    Area Location;
    Land land;
    ProjectPreliminaryActivities preliminaryActivities;
    String projectActivities;
    String rationaleOfProject;
    String objective1;
    String objective2;
    String objective3;
    String whatIsTheProblem;
    String whatAreTheRootCauses;
    String howThisFullFillExistingGap;
    String modeOfIntervention;
    Benificiaries benificiaries;
    String policyElementOfFrameWork;
    String contribution;

    String sectoralMasterPlan;
    String sectoralMasterPlanPriority;
    boolean isProjectIncludedToTheMasterPlan;
    String sectroStrategy;
    StakeHolders stakeHolders;
    Partners partners;
    String economicImapact;
    String enviromentImpact;
    String SocialImpact;
    ProjectOutcomes projectOutcomes;
    ProjectOutputs projectOutputs;
    Activity activity;
    AligningOfProjectWithRelavantSustainableGoals alignmentOftheSustainableGoal;

    boolean potentialNegativeImpactOnResidences;
    boolean potentialNegativeImpactOnSchools;
    boolean potentialNegativeImpactOnHospitals;
    boolean potentialNegativeImpactOnBuildUpAreas;
    boolean potentialNegativeImpactOnHomeGardens;
    boolean potentialNegativeImpactOnPaddyAndFarmLands;
    boolean potentialNegativeImpactOnOtherAgriculturalLands;
    boolean potentialNegativeImpactOnArcheologicalSites;
    boolean potentialNegativeImpactOnReligiousPlaces;
    boolean potentialNegativeImpactOnRiversAndStreams;
    boolean potentialNegativeImpactOnLagoons;
    boolean potentialNegativeImpactOnWetlands;
    boolean potentialNegativeImpactOnMangrove;
    boolean potentialNegativeImpactOnCostalScrub;
    boolean potentialNegativeImpactOnWatershedsAndCatchmentAreas;
    boolean potentialNegativeImpactOnScrubForest;
    boolean potentialNegativeImpactOnOtherItems;

    String majorAssumptions;
    String riskMitigationMeasures;
    String migitationMeasuresInProjectActivities;

    String DRRMainstreamIdentified;
    String DRRMainstreamRequiredMitigationActivitiesAndResiliencFeatures;
    double DRRAdditionalCostForMitigationMeasures;
    String DRRSocioBenifitsAchievements;
    ProjectMonitoringPlan projectMonitoringPlan;

    //15.2 Problem
    ProjectBudgetCostBreakdown costBreakdown;
    ProjectBudgetDetailsOfActivities BudgetDetailsOfActivities;
    FinancingMethod financingMethod;
    FinancialRevenueForecast revenueForecast;
    ProjectOperationMaintananceCost operationAndMaintananceCost;

    ResettlementOfActiviteis resettlementActivities;
    GenderPrespective genderPrespective;

    boolean isProjectIdentifyAbledPerson;
    String abledPersonDescription;

    String implementAgency;
    String deatailsOfImpelementationMechanism;

    List<projectStaffRequirementImplementation> staffRequirement;

    CompletionSutainabilityMaintanance arrangmentOfSustainabilityAndOperations;

    String arrangementPlanWithAgencyDesc;

    List<ProjectOperationMaintenanceCompletion> staffOperationMaintanaceAfterCompletion;

    String EirrAndFirr;
    String EnpvAndFnpv;
    String paybackPeriod;
    double costBenefitRatio;

    ApplicantProjectProponent applicantProjectProponent;
    ApplicantMinistryOrProvincialCouncil applicantMinistryProvincialCouncil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectSubmissionForm)) {
            return false;
        }
        ProjectSubmissionForm other = (ProjectSubmissionForm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.divudi.entity.ProjectSubmissionForm[ id=" + id + " ]";
    }

}
