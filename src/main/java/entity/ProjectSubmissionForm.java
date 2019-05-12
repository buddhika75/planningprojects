/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

    private String projectTitle;
    @ManyToOne
    private Item sector;
    private Boolean allIsland;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProjectArea> provinces;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProjectArea> districts;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProjectArea> dsDivisions;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProjectArea> gnDivisions;
    @ManyToOne
    private Area Location;
    private double totalAreaOfLandRequirement;
    private boolean landHasIdentified;
    private Double landAreaOwnedByImplementingAgency;
    private Double landAreaOwnedByGovernmentAgency;
    private Double landAreaOwnedByPrivateSector;
    private Boolean needToBePurchasedOrAcquired;
    private Double costToPurchaseOrAcquire;

    @Enumerated(EnumType.STRING)
    private YesNoNotNecessary preFeasibility;
    @Enumerated(EnumType.STRING)
    private YesNoNotNecessary feasibility;
    @Enumerated(EnumType.STRING)
    private YesNoNotNecessary detailedDesign;
    @Enumerated(EnumType.STRING)
    private YesNoNotNecessary StrateginEnviromentalAssesment;
    @Enumerated(EnumType.STRING)
    private YesNoNotNecessary initialEnvironmentalAssessment;
    @Enumerated(EnumType.STRING)
    private YesNoNotNecessary environmentalImpactAssessment;
    @Enumerated(EnumType.STRING)
    private YesNoNotNecessary disasterRiskAssessment;
    @Enumerated(EnumType.STRING)
    private YesNoNotNecessary NBROClearance;
    @Enumerated(EnumType.STRING)
    private YesNoNotNecessary archeologicalClearance;
    @Enumerated(EnumType.STRING)
    private YesNoNotNecessary landClearanceFromRelevantParties;
    @Enumerated(EnumType.STRING)
    private YesNoNotNecessary socialImpactAssessment;
    @Lob
    private String otherProjectPreliminaryActivities;

    @Lob
    private String projectObjectives;
    @Lob
    private String whatIsTheProblem;
    @Lob
    private String whatAreTheRootCauses;
    @Lob
    private String howThisFullFillExistingGap;
    @Lob
    private String modeOfIntervention;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Beneficiary> benificiaries;

    @Lob
    private String policyElementOfFrameWorkToMostRelevantProject;
    @Lob
    private String contributionToPolictElements;

    @Lob

    private String sectoralMasterPlan;

    private Boolean isProjectIncludedToTheMasterPlan;
    @Lob
    private String sectoralMasterPlanPriority;

    private String sectroStrategy;
    private List<ProjectInstitution> stakeHolders;
    private List<ProjectInstitution> partners;
    @Lob
    private String economicImapact;
    @Lob
    private String enviromentImpact;
    @Lob
    private String SocialImpact;
    private List<ProjectOutcome> projectOutcomes;
//    
//    ProjectOutput projectOutputs;
//    Activity activity;
//    AligningOfProjectWithRelavantSustainableGoals alignmentOftheSustainableGoal;
//
//    boolean potentialNegativeImpactOnResidences;
//    boolean potentialNegativeImpactOnSchools;
//    boolean potentialNegativeImpactOnHospitals;
//    boolean potentialNegativeImpactOnBuildUpAreas;
//    boolean potentialNegativeImpactOnHomeGardens;
//    boolean potentialNegativeImpactOnPaddyAndFarmLands;
//    boolean potentialNegativeImpactOnOtherAgriculturalLands;
//    boolean potentialNegativeImpactOnArcheologicalSites;
//    boolean potentialNegativeImpactOnReligiousPlaces;
//    boolean potentialNegativeImpactOnRiversAndStreams;
//    boolean potentialNegativeImpactOnLagoons;
//    boolean potentialNegativeImpactOnWetlands;
//    boolean potentialNegativeImpactOnMangrove;
//    boolean potentialNegativeImpactOnCostalScrub;
//    boolean potentialNegativeImpactOnWatershedsAndCatchmentAreas;
//    boolean potentialNegativeImpactOnScrubForest;
//    boolean potentialNegativeImpactOnOtherItems;
//
//    String majorAssumptions;
//    String riskMitigationMeasures;
//    String migitationMeasuresInProjectActivities;
//
//    String DRRMainstreamIdentified;
//    String DRRMainstreamRequiredMitigationActivitiesAndResiliencFeatures;
//    double DRRAdditionalCostForMitigationMeasures;
//    String DRRSocioBenifitsAchievements;
//    ProjectMonitoringPlan projectMonitoringPlan;
//
//    //15.2 Problem
//    ProjectBudgetCostBreakdown costBreakdown;
//    ProjectBudgetDetailsOfActivities BudgetDetailsOfActivities;
//    FinancingMethod financingMethod;
//    FinancialRevenueForecast revenueForecast;
//    ProjectOperationMaintananceCost operationAndMaintananceCost;
//
//    ResettlementOfActiviteis resettlementActivities;
//    GenderPrespective genderPrespective;
//
//    boolean isProjectIdentifyAbledPerson;
//    String abledPersonDescription;
//
//    String implementAgency;
//    String deatailsOfImpelementationMechanism;
//
//    List<projectStaffRequirementImplementation> staffRequirement;
//
//    CompletionSutainabilityMaintanance arrangmentOfSustainabilityAndOperations;
//
//    String arrangementPlanWithAgencyDesc;
//
//    List<ProjectOperationMaintenanceCompletion> staffOperationMaintanaceAfterCompletion;
//
//    String EirrAndFirr;
//    String EnpvAndFnpv;
//    String paybackPeriod;
//    double costBenefitRatio;
//
//    ApplicantProjectProponent applicantProjectProponent;
//    ApplicantMinistryOrProvincialCouncil applicantMinistryProvincialCouncil;

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

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public Item getSector() {
        return sector;
    }

    public void setSector(Item sector) {
        this.sector = sector;
    }

    public Boolean getAllIsland() {
        return allIsland;
    }

    public void setAllIsland(Boolean allIsland) {
        this.allIsland = allIsland;
    }

    public List<ProjectArea> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<ProjectArea> provinces) {
        this.provinces = provinces;
    }

    public List<ProjectArea> getDistricts() {
        return districts;
    }

    public void setDistricts(List<ProjectArea> districts) {
        this.districts = districts;
    }

    public List<ProjectArea> getDsDivisions() {
        return dsDivisions;
    }

    public void setDsDivisions(List<ProjectArea> dsDivisions) {
        this.dsDivisions = dsDivisions;
    }

    public List<ProjectArea> getGnDivisions() {
        return gnDivisions;
    }

    public void setGnDivisions(List<ProjectArea> gnDivisions) {
        this.gnDivisions = gnDivisions;
    }

    public Area getLocation() {
        return Location;
    }

    public void setLocation(Area Location) {
        this.Location = Location;
    }

    public double getTotalAreaOfLandRequirement() {
        return totalAreaOfLandRequirement;
    }

    public void setTotalAreaOfLandRequirement(double totalAreaOfLandRequirement) {
        this.totalAreaOfLandRequirement = totalAreaOfLandRequirement;
    }

    public boolean isLandHasIdentified() {
        return landHasIdentified;
    }

    public void setLandHasIdentified(boolean landHasIdentified) {
        this.landHasIdentified = landHasIdentified;
    }

    public Double getLandAreaOwnedByImplementingAgency() {
        return landAreaOwnedByImplementingAgency;
    }

    public void setLandAreaOwnedByImplementingAgency(Double landAreaOwnedByImplementingAgency) {
        this.landAreaOwnedByImplementingAgency = landAreaOwnedByImplementingAgency;
    }

    public Double getLandAreaOwnedByGovernmentAgency() {
        return landAreaOwnedByGovernmentAgency;
    }

    public void setLandAreaOwnedByGovernmentAgency(Double landAreaOwnedByGovernmentAgency) {
        this.landAreaOwnedByGovernmentAgency = landAreaOwnedByGovernmentAgency;
    }

    public Double getLandAreaOwnedByPrivateSector() {
        return landAreaOwnedByPrivateSector;
    }

    public void setLandAreaOwnedByPrivateSector(Double landAreaOwnedByPrivateSector) {
        this.landAreaOwnedByPrivateSector = landAreaOwnedByPrivateSector;
    }

    public Boolean getNeedToBePurchasedOrAcquired() {
        return needToBePurchasedOrAcquired;
    }

    public void setNeedToBePurchasedOrAcquired(Boolean needToBePurchasedOrAcquired) {
        this.needToBePurchasedOrAcquired = needToBePurchasedOrAcquired;
    }

    public Double getCostToPurchaseOrAcquire() {
        return costToPurchaseOrAcquire;
    }

    public void setCostToPurchaseOrAcquire(Double costToPurchaseOrAcquire) {
        this.costToPurchaseOrAcquire = costToPurchaseOrAcquire;
    }

    public YesNoNotNecessary getPreFeasibility() {
        return preFeasibility;
    }

    public void setPreFeasibility(YesNoNotNecessary preFeasibility) {
        this.preFeasibility = preFeasibility;
    }

    public YesNoNotNecessary getFeasibility() {
        return feasibility;
    }

    public void setFeasibility(YesNoNotNecessary feasibility) {
        this.feasibility = feasibility;
    }

    public YesNoNotNecessary getDetailedDesign() {
        return detailedDesign;
    }

    public void setDetailedDesign(YesNoNotNecessary detailedDesign) {
        this.detailedDesign = detailedDesign;
    }

    public YesNoNotNecessary getStrateginEnviromentalAssesment() {
        return StrateginEnviromentalAssesment;
    }

    public void setStrateginEnviromentalAssesment(YesNoNotNecessary StrateginEnviromentalAssesment) {
        this.StrateginEnviromentalAssesment = StrateginEnviromentalAssesment;
    }

    public YesNoNotNecessary getInitialEnvironmentalAssessment() {
        return initialEnvironmentalAssessment;
    }

    public void setInitialEnvironmentalAssessment(YesNoNotNecessary initialEnvironmentalAssessment) {
        this.initialEnvironmentalAssessment = initialEnvironmentalAssessment;
    }

    public YesNoNotNecessary getEnvironmentalImpactAssessment() {
        return environmentalImpactAssessment;
    }

    public void setEnvironmentalImpactAssessment(YesNoNotNecessary environmentalImpactAssessment) {
        this.environmentalImpactAssessment = environmentalImpactAssessment;
    }

    public YesNoNotNecessary getDisasterRiskAssessment() {
        return disasterRiskAssessment;
    }

    public void setDisasterRiskAssessment(YesNoNotNecessary disasterRiskAssessment) {
        this.disasterRiskAssessment = disasterRiskAssessment;
    }

    public YesNoNotNecessary getNBROClearance() {
        return NBROClearance;
    }

    public void setNBROClearance(YesNoNotNecessary NBROClearance) {
        this.NBROClearance = NBROClearance;
    }

    public YesNoNotNecessary getArcheologicalClearance() {
        return archeologicalClearance;
    }

    public void setArcheologicalClearance(YesNoNotNecessary archeologicalClearance) {
        this.archeologicalClearance = archeologicalClearance;
    }

    public YesNoNotNecessary getLandClearanceFromRelevantParties() {
        return landClearanceFromRelevantParties;
    }

    public void setLandClearanceFromRelevantParties(YesNoNotNecessary landClearanceFromRelevantParties) {
        this.landClearanceFromRelevantParties = landClearanceFromRelevantParties;
    }

    public YesNoNotNecessary getSocialImpactAssessment() {
        return socialImpactAssessment;
    }

    public void setSocialImpactAssessment(YesNoNotNecessary socialImpactAssessment) {
        this.socialImpactAssessment = socialImpactAssessment;
    }

    public String getOtherProjectPreliminaryActivities() {
        return otherProjectPreliminaryActivities;
    }

    public void setOtherProjectPreliminaryActivities(String otherProjectPreliminaryActivities) {
        this.otherProjectPreliminaryActivities = otherProjectPreliminaryActivities;
    }

    public String getProjectObjectives() {
        return projectObjectives;
    }

    public void setProjectObjectives(String projectObjectives) {
        this.projectObjectives = projectObjectives;
    }

    public String getWhatIsTheProblem() {
        return whatIsTheProblem;
    }

    public void setWhatIsTheProblem(String whatIsTheProblem) {
        this.whatIsTheProblem = whatIsTheProblem;
    }

    public String getWhatAreTheRootCauses() {
        return whatAreTheRootCauses;
    }

    public void setWhatAreTheRootCauses(String whatAreTheRootCauses) {
        this.whatAreTheRootCauses = whatAreTheRootCauses;
    }

    public String getHowThisFullFillExistingGap() {
        return howThisFullFillExistingGap;
    }

    public void setHowThisFullFillExistingGap(String howThisFullFillExistingGap) {
        this.howThisFullFillExistingGap = howThisFullFillExistingGap;
    }

    public String getModeOfIntervention() {
        return modeOfIntervention;
    }

    public void setModeOfIntervention(String modeOfIntervention) {
        this.modeOfIntervention = modeOfIntervention;
    }

    public List<Beneficiary> getBenificiaries() {
        return benificiaries;
    }

    public void setBenificiaries(List<Beneficiary> benificiaries) {
        this.benificiaries = benificiaries;
    }

    public String getPolicyElementOfFrameWorkToMostRelevantProject() {
        return policyElementOfFrameWorkToMostRelevantProject;
    }

    public void setPolicyElementOfFrameWorkToMostRelevantProject(String policyElementOfFrameWorkToMostRelevantProject) {
        this.policyElementOfFrameWorkToMostRelevantProject = policyElementOfFrameWorkToMostRelevantProject;
    }

    public String getContributionToPolictElements() {
        return contributionToPolictElements;
    }

    public void setContributionToPolictElements(String contributionToPolictElements) {
        this.contributionToPolictElements = contributionToPolictElements;
    }

    public String getSectoralMasterPlan() {
        return sectoralMasterPlan;
    }

    public void setSectoralMasterPlan(String sectoralMasterPlan) {
        this.sectoralMasterPlan = sectoralMasterPlan;
    }

    public Boolean getIsProjectIncludedToTheMasterPlan() {
        return isProjectIncludedToTheMasterPlan;
    }

    public void setIsProjectIncludedToTheMasterPlan(Boolean isProjectIncludedToTheMasterPlan) {
        this.isProjectIncludedToTheMasterPlan = isProjectIncludedToTheMasterPlan;
    }

    public String getSectoralMasterPlanPriority() {
        return sectoralMasterPlanPriority;
    }

    public void setSectoralMasterPlanPriority(String sectoralMasterPlanPriority) {
        this.sectoralMasterPlanPriority = sectoralMasterPlanPriority;
    }

    public String getSectroStrategy() {
        return sectroStrategy;
    }

    public void setSectroStrategy(String sectroStrategy) {
        this.sectroStrategy = sectroStrategy;
    }

    public List<ProjectInstitution> getStakeHolders() {
        return stakeHolders;
    }

    public void setStakeHolders(List<ProjectInstitution> stakeHolders) {
        this.stakeHolders = stakeHolders;
    }

    public List<ProjectInstitution> getPartners() {
        return partners;
    }

    public void setPartners(List<ProjectInstitution> partners) {
        this.partners = partners;
    }

    public String getEconomicImapact() {
        return economicImapact;
    }

    public void setEconomicImapact(String economicImapact) {
        this.economicImapact = economicImapact;
    }

    public String getEnviromentImpact() {
        return enviromentImpact;
    }

    public void setEnviromentImpact(String enviromentImpact) {
        this.enviromentImpact = enviromentImpact;
    }

    public String getSocialImpact() {
        return SocialImpact;
    }

    public void setSocialImpact(String SocialImpact) {
        this.SocialImpact = SocialImpact;
    }

    public List<ProjectOutcome> getProjectOutcomes() {
        return projectOutcomes;
    }

    public void setProjectOutcomes(List<ProjectOutcome> projectOutcomes) {
        this.projectOutcomes = projectOutcomes;
    }

}
