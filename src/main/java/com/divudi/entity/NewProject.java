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
public class NewProject {
    
    private String pTitle;
    private String sector;
    private Area Location;
    private Land land;
    private ProjectPreliminaryActivities preliminaryActivities;
    private String projectActivities;
    private String rationaleOfProject;
    private String objective1;
    private String objective2;
    private String objective3;
    private String whatIsTheProblem;
    private String whatAreTheRootCauses;
    private String howThisFullFillExistingGap;
    private String modeOfIntervention;
    private Benificiaries benificiaries;
    private String policyElementOfFrameWork;
    private String contribution;
    
    private String sectoralMasterPlan;
    private String sectoralMasterPlanPriority;
    private boolean isProjectIncludedToTheMasterPlan;
    private String sectroStrategy;
    private StakeHolders stakeHolders;
    private Partners partners;
    private String economicImapact;
    private String enviromentImpact;
    private String SocialImpact;
    private ProjectOutcomes projectOutcomes;
    private ProjectOutputs projectOutputs;
    private Activity activity;
    private AligningOfProjectWithRelavantSustainableGoals alignmentOftheSustainableGoal;
    
    private boolean potentialNegativeImpactOnResidences;
    private boolean potentialNegativeImpactOnSchools;
    private boolean potentialNegativeImpactOnHospitals;
    private boolean potentialNegativeImpactOnBuildUpAreas;
    private boolean potentialNegativeImpactOnHomeGardens;
    private boolean potentialNegativeImpactOnPaddyAndFarmLands;
    private boolean potentialNegativeImpactOnOtherAgriculturalLands;
    private boolean potentialNegativeImpactOnArcheologicalSites;
    private boolean potentialNegativeImpactOnReligiousPlaces;
    private boolean potentialNegativeImpactOnRiversAndStreams;
    private boolean potentialNegativeImpactOnLagoons;
    private boolean potentialNegativeImpactOnWetlands;
    private boolean potentialNegativeImpactOnMangrove;
    private boolean potentialNegativeImpactOnCostalScrub;
    private boolean potentialNegativeImpactOnWatershedsAndCatchmentAreas;
    private boolean potentialNegativeImpactOnScrubForest;
    private boolean potentialNegativeImpactOnOtherItems;
    
    private String majorAssumptions;
    private String riskMitigationMeasures;
    private String migitationMeasuresInProjectActivities;
    
    private String DRRMainstreamIdentified;
    private String DRRMainstreamRequiredMitigationActivitiesAndResiliencFeatures;
    private double DRRAdditionalCostForMitigationMeasures;
    private String DRRSocioBenifitsAchievements;
    private ProjectMonitoringPlan projectMonitoringPlan;
    
    //15.2 Problem
    
    private ProjectBudgetCostBreakdown costBreakdown;
    private ProjectBudgetDetailsOfActivities BudgetDetailsOfActivities;
    private FinancingMethod financingMethod;
    private FinancialRevenueForecast revenueForecast;
    private ProjectOperationMaintananceCost operationAndMaintananceCost;
    
    private ResettlementOfActiviteis resettlementActivities;
    private GenderPrespective genderPrespective;
    
    private boolean isProjectIdentifyAbledPerson;
    private String abledPersonDescription;
    
    private String implementAgency;
    private String deatailsOfImpelementationMechanism;
    
    private List<projectStaffRequirementImplementation> staffRequirement;
    
    private CompletionSutainabilityMaintanance arrangmentOfSustainabilityAndOperations;
    
    private String arrangementPlanWithAgencyDesc;
    
    private List<ProjectOperationMaintenanceCompletion> staffOperationMaintanaceAfterCompletion;
    
    private String EirrAndFirr;
    private String EnpvAndFnpv;
    private String paybackPeriod;
    private double costBenefitRatio;
    
    private ApplicantProjectProponent applicantProjectProponent;
    private ApplicantMinistryOrProvincialCouncil applicantMinistryProvincialCouncil;
    
    /**
     * @return the pTitle
     */
    public String getpTitle() {
        return pTitle;
    }

    /**
     * @param pTitle the pTitle to set
     */
    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    /**
     * @return the sector
     */
    public String getSector() {
        return sector;
    }

    /**
     * @param sector the sector to set
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * @return the Location
     */
    public Area getLocation() {
        return Location;
    }

    /**
     * @param Location the Location to set
     */
    public void setLocation(Area Location) {
        this.Location = Location;
    }

    /**
     * @return the land
     */
    public Land getLand() {
        return land;
    }

    /**
     * @param land the land to set
     */
    public void setLand(Land land) {
        this.land = land;
    }

    /**
     * @return the preliminaryActivities
     */
    public ProjectPreliminaryActivities getPreliminaryActivities() {
        return preliminaryActivities;
    }

    /**
     * @param preliminaryActivities the preliminaryActivities to set
     */
    public void setPreliminaryActivities(ProjectPreliminaryActivities preliminaryActivities) {
        this.preliminaryActivities = preliminaryActivities;
    }

    /**
     * @return the projectActivities
     */
    public String getProjectActivities() {
        return projectActivities;
    }

    /**
     * @param projectActivities the projectActivities to set
     */
    public void setProjectActivities(String projectActivities) {
        this.projectActivities = projectActivities;
    }

    /**
     * @return the benificiaries
     */
    public Benificiaries getBenificiaries() {
        return benificiaries;
    }

    /**
     * @param benificiaries the benificiaries to set
     */
    public void setBenificiaries(Benificiaries benificiaries) {
        this.benificiaries = benificiaries;
    }

    /**
     * @return the rationaleOfProject
     */
    public String getRationaleOfProject() {
        return rationaleOfProject;
    }

    /**
     * @param rationaleOfProject the rationaleOfProject to set
     */
    public void setRationaleOfProject(String rationaleOfProject) {
        this.rationaleOfProject = rationaleOfProject;
    }

    public String getObjective1() {
        return objective1;
    }

    public void setObjective1(String objective1) {
        this.objective1 = objective1;
    }

    public String getObjective2() {
        return objective2;
    }

    public void setObjective2(String objective2) {
        this.objective2 = objective2;
    }

    public String getObjective3() {
        return objective3;
    }

    public void setObjective3(String objective3) {
        this.objective3 = objective3;
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

    public String getPolicyElementOfFrameWork() {
        return policyElementOfFrameWork;
    }

    public void setPolicyElementOfFrameWork(String policyElementOfFrameWork) {
        this.policyElementOfFrameWork = policyElementOfFrameWork;
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public String getSectoralMasterPlan() {
        return sectoralMasterPlan;
    }

    public void setSectoralMasterPlan(String sectoralMasterPlan) {
        this.sectoralMasterPlan = sectoralMasterPlan;
    }

    public String getSectoralMasterPlanPriority() {
        return sectoralMasterPlanPriority;
    }

    public void setSectoralMasterPlanPriority(String sectoralMasterPlanPriority) {
        this.sectoralMasterPlanPriority = sectoralMasterPlanPriority;
    }

    public boolean isIsProjectIncludedToTheMasterPlan() {
        return isProjectIncludedToTheMasterPlan;
    }

    public void setIsProjectIncludedToTheMasterPlan(boolean isProjectIncludedToTheMasterPlan) {
        this.isProjectIncludedToTheMasterPlan = isProjectIncludedToTheMasterPlan;
    }

    public String getSectroStrategy() {
        return sectroStrategy;
    }

    public void setSectroStrategy(String sectroStrategy) {
        this.sectroStrategy = sectroStrategy;
    }

    public StakeHolders getStakeHolders() {
        return stakeHolders;
    }

    public void setStakeHolders(StakeHolders stakeHolders) {
        this.stakeHolders = stakeHolders;
    }

    public Partners getPartners() {
        return partners;
    }

    public void setPartners(Partners partners) {
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

    public ProjectOutcomes getProjectOutcomes() {
        return projectOutcomes;
    }

    public void setProjectOutcomes(ProjectOutcomes projectOutcomes) {
        this.projectOutcomes = projectOutcomes;
    }

    public ProjectOutputs getProjectOutputs() {
        return projectOutputs;
    }

    public void setProjectOutputs(ProjectOutputs projectOutputs) {
        this.projectOutputs = projectOutputs;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public AligningOfProjectWithRelavantSustainableGoals getAlignmentOftheSustainableGoal() {
        return alignmentOftheSustainableGoal;
    }

    public void setAlignmentOftheSustainableGoal(AligningOfProjectWithRelavantSustainableGoals alignmentOftheSustainableGoal) {
        this.alignmentOftheSustainableGoal = alignmentOftheSustainableGoal;
    }

    public boolean isPotentialNegativeImpactOnResidences() {
        return potentialNegativeImpactOnResidences;
    }

    public void setPotentialNegativeImpactOnResidences(boolean potentialNegativeImpactOnResidences) {
        this.potentialNegativeImpactOnResidences = potentialNegativeImpactOnResidences;
    }

    public boolean isPotentialNegativeImpactOnSchools() {
        return potentialNegativeImpactOnSchools;
    }

    public void setPotentialNegativeImpactOnSchools(boolean potentialNegativeImpactOnSchools) {
        this.potentialNegativeImpactOnSchools = potentialNegativeImpactOnSchools;
    }

    public boolean isPotentialNegativeImpactOnHospitals() {
        return potentialNegativeImpactOnHospitals;
    }

    public void setPotentialNegativeImpactOnHospitals(boolean potentialNegativeImpactOnHospitals) {
        this.potentialNegativeImpactOnHospitals = potentialNegativeImpactOnHospitals;
    }

    public boolean isPotentialNegativeImpactOnBuildUpAreas() {
        return potentialNegativeImpactOnBuildUpAreas;
    }

    public void setPotentialNegativeImpactOnBuildUpAreas(boolean potentialNegativeImpactOnBuildUpAreas) {
        this.potentialNegativeImpactOnBuildUpAreas = potentialNegativeImpactOnBuildUpAreas;
    }

    public boolean isPotentialNegativeImpactOnHomeGardens() {
        return potentialNegativeImpactOnHomeGardens;
    }

    public void setPotentialNegativeImpactOnHomeGardens(boolean potentialNegativeImpactOnHomeGardens) {
        this.potentialNegativeImpactOnHomeGardens = potentialNegativeImpactOnHomeGardens;
    }

    public boolean isPotentialNegativeImpactOnPaddyAndFarmLands() {
        return potentialNegativeImpactOnPaddyAndFarmLands;
    }

    public void setPotentialNegativeImpactOnPaddyAndFarmLands(boolean potentialNegativeImpactOnPaddyAndFarmLands) {
        this.potentialNegativeImpactOnPaddyAndFarmLands = potentialNegativeImpactOnPaddyAndFarmLands;
    }

    public boolean isPotentialNegativeImpactOnOtherAgriculturalLands() {
        return potentialNegativeImpactOnOtherAgriculturalLands;
    }

    public void setPotentialNegativeImpactOnOtherAgriculturalLands(boolean potentialNegativeImpactOnOtherAgriculturalLands) {
        this.potentialNegativeImpactOnOtherAgriculturalLands = potentialNegativeImpactOnOtherAgriculturalLands;
    }

    public boolean isPotentialNegativeImpactOnArcheologicalSites() {
        return potentialNegativeImpactOnArcheologicalSites;
    }

    public void setPotentialNegativeImpactOnArcheologicalSites(boolean potentialNegativeImpactOnArcheologicalSites) {
        this.potentialNegativeImpactOnArcheologicalSites = potentialNegativeImpactOnArcheologicalSites;
    }

    public boolean isPotentialNegativeImpactOnReligiousPlaces() {
        return potentialNegativeImpactOnReligiousPlaces;
    }

    public void setPotentialNegativeImpactOnReligiousPlaces(boolean potentialNegativeImpactOnReligiousPlaces) {
        this.potentialNegativeImpactOnReligiousPlaces = potentialNegativeImpactOnReligiousPlaces;
    }

    public boolean isPotentialNegativeImpactOnRiversAndStreams() {
        return potentialNegativeImpactOnRiversAndStreams;
    }

    public void setPotentialNegativeImpactOnRiversAndStreams(boolean potentialNegativeImpactOnRiversAndStreams) {
        this.potentialNegativeImpactOnRiversAndStreams = potentialNegativeImpactOnRiversAndStreams;
    }

    public boolean isPotentialNegativeImpactOnLagoons() {
        return potentialNegativeImpactOnLagoons;
    }

    public void setPotentialNegativeImpactOnLagoons(boolean potentialNegativeImpactOnLagoons) {
        this.potentialNegativeImpactOnLagoons = potentialNegativeImpactOnLagoons;
    }

    public boolean isPotentialNegativeImpactOnWetlands() {
        return potentialNegativeImpactOnWetlands;
    }

    public void setPotentialNegativeImpactOnWetlands(boolean potentialNegativeImpactOnWetlands) {
        this.potentialNegativeImpactOnWetlands = potentialNegativeImpactOnWetlands;
    }

    public boolean isPotentialNegativeImpactOnMangrove() {
        return potentialNegativeImpactOnMangrove;
    }

    public void setPotentialNegativeImpactOnMangrove(boolean potentialNegativeImpactOnMangrove) {
        this.potentialNegativeImpactOnMangrove = potentialNegativeImpactOnMangrove;
    }

    public boolean isPotentialNegativeImpactOnCostalScrub() {
        return potentialNegativeImpactOnCostalScrub;
    }

    public void setPotentialNegativeImpactOnCostalScrub(boolean potentialNegativeImpactOnCostalScrub) {
        this.potentialNegativeImpactOnCostalScrub = potentialNegativeImpactOnCostalScrub;
    }

    public boolean isPotentialNegativeImpactOnWatershedsAndCatchmentAreas() {
        return potentialNegativeImpactOnWatershedsAndCatchmentAreas;
    }

    public void setPotentialNegativeImpactOnWatershedsAndCatchmentAreas(boolean potentialNegativeImpactOnWatershedsAndCatchmentAreas) {
        this.potentialNegativeImpactOnWatershedsAndCatchmentAreas = potentialNegativeImpactOnWatershedsAndCatchmentAreas;
    }

    public boolean isPotentialNegativeImpactOnScrubForest() {
        return potentialNegativeImpactOnScrubForest;
    }

    public void setPotentialNegativeImpactOnScrubForest(boolean potentialNegativeImpactOnScrubForest) {
        this.potentialNegativeImpactOnScrubForest = potentialNegativeImpactOnScrubForest;
    }

    public boolean isPotentialNegativeImpactOnOtherItems() {
        return potentialNegativeImpactOnOtherItems;
    }

    public void setPotentialNegativeImpactOnOtherItems(boolean potentialNegativeImpactOnOtherItems) {
        this.potentialNegativeImpactOnOtherItems = potentialNegativeImpactOnOtherItems;
    }

    public String getMajorAssumptions() {
        return majorAssumptions;
    }

    public void setMajorAssumptions(String majorAssumptions) {
        this.majorAssumptions = majorAssumptions;
    }

    public String getRiskMitigationMeasures() {
        return riskMitigationMeasures;
    }

    public void setRiskMitigationMeasures(String riskMitigationMeasures) {
        this.riskMitigationMeasures = riskMitigationMeasures;
    }

    public String getMigitationMeasuresInProjectActivities() {
        return migitationMeasuresInProjectActivities;
    }

    public void setMigitationMeasuresInProjectActivities(String migitationMeasuresInProjectActivities) {
        this.migitationMeasuresInProjectActivities = migitationMeasuresInProjectActivities;
    }

    public String getDRRMainstreamIdentified() {
        return DRRMainstreamIdentified;
    }

    public void setDRRMainstreamIdentified(String DRRMainstreamIdentified) {
        this.DRRMainstreamIdentified = DRRMainstreamIdentified;
    }

    public String getDRRMainstreamRequiredMitigationActivitiesAndResiliencFeatures() {
        return DRRMainstreamRequiredMitigationActivitiesAndResiliencFeatures;
    }

    public void setDRRMainstreamRequiredMitigationActivitiesAndResiliencFeatures(String DRRMainstreamRequiredMitigationActivitiesAndResiliencFeatures) {
        this.DRRMainstreamRequiredMitigationActivitiesAndResiliencFeatures = DRRMainstreamRequiredMitigationActivitiesAndResiliencFeatures;
    }

    public double getDRRAdditionalCostForMitigationMeasures() {
        return DRRAdditionalCostForMitigationMeasures;
    }

    public void setDRRAdditionalCostForMitigationMeasures(double DRRAdditionalCostForMitigationMeasures) {
        this.DRRAdditionalCostForMitigationMeasures = DRRAdditionalCostForMitigationMeasures;
    }

    public String getDRRSocioBenifitsAchievements() {
        return DRRSocioBenifitsAchievements;
    }

    public void setDRRSocioBenifitsAchievements(String DRRSocioBenifitsAchievements) {
        this.DRRSocioBenifitsAchievements = DRRSocioBenifitsAchievements;
    }

    public ProjectMonitoringPlan getProjectMonitoringPlan() {
        return projectMonitoringPlan;
    }

    public void setProjectMonitoringPlan(ProjectMonitoringPlan projectMonitoringPlan) {
        this.projectMonitoringPlan = projectMonitoringPlan;
    }

    public ProjectBudgetCostBreakdown getCostBreakdown() {
        return costBreakdown;
    }

    public void setCostBreakdown(ProjectBudgetCostBreakdown costBreakdown) {
        this.costBreakdown = costBreakdown;
    }

    public ProjectBudgetDetailsOfActivities getBudgetDetailsOfActivities() {
        return BudgetDetailsOfActivities;
    }

    public void setBudgetDetailsOfActivities(ProjectBudgetDetailsOfActivities BudgetDetailsOfActivities) {
        this.BudgetDetailsOfActivities = BudgetDetailsOfActivities;
    }

    public FinancingMethod getFinancingMethod() {
        return financingMethod;
    }

    public void setFinancingMethod(FinancingMethod financingMethod) {
        this.financingMethod = financingMethod;
    }

    public FinancialRevenueForecast getRevenueForecast() {
        return revenueForecast;
    }

    public void setRevenueForecast(FinancialRevenueForecast revenueForecast) {
        this.revenueForecast = revenueForecast;
    }

    public ProjectOperationMaintananceCost getOperationAndMaintananceCost() {
        return operationAndMaintananceCost;
    }

    public void setOperationAndMaintananceCost(ProjectOperationMaintananceCost operationAndMaintananceCost) {
        this.operationAndMaintananceCost = operationAndMaintananceCost;
    }

    public ResettlementOfActiviteis getResettlementActivities() {
        return resettlementActivities;
    }

    public void setResettlementActivities(ResettlementOfActiviteis resettlementActivities) {
        this.resettlementActivities = resettlementActivities;
    }

    public GenderPrespective getGenderPrespective() {
        return genderPrespective;
    }

    public void setGenderPrespective(GenderPrespective genderPrespective) {
        this.genderPrespective = genderPrespective;
    }

    public boolean isIsProjectIdentifyAbledPerson() {
        return isProjectIdentifyAbledPerson;
    }

    public void setIsProjectIdentifyAbledPerson(boolean isProjectIdentifyAbledPerson) {
        this.isProjectIdentifyAbledPerson = isProjectIdentifyAbledPerson;
    }

    public String getAbledPersonDescription() {
        return abledPersonDescription;
    }

    public void setAbledPersonDescription(String abledPersonDescription) {
        this.abledPersonDescription = abledPersonDescription;
    }

    public String getImplementAgency() {
        return implementAgency;
    }

    public void setImplementAgency(String implementAgency) {
        this.implementAgency = implementAgency;
    }

    public String getDeatailsOfImpelementationMechanism() {
        return deatailsOfImpelementationMechanism;
    }

    public void setDeatailsOfImpelementationMechanism(String deatailsOfImpelementationMechanism) {
        this.deatailsOfImpelementationMechanism = deatailsOfImpelementationMechanism;
    }

    public List<projectStaffRequirementImplementation> getStaffRequirement() {
        return staffRequirement;
    }

    public void setStaffRequirement(List<projectStaffRequirementImplementation> staffRequirement) {
        this.staffRequirement = staffRequirement;
    }

    public CompletionSutainabilityMaintanance getArrangmentOfSustainabilityAndOperations() {
        return arrangmentOfSustainabilityAndOperations;
    }

    public void setArrangmentOfSustainabilityAndOperations(CompletionSutainabilityMaintanance ArrangmentOfSustainabilityAndOperations) {
        this.arrangmentOfSustainabilityAndOperations = ArrangmentOfSustainabilityAndOperations;
    }

    public String getArrangementPlanWithAgencyDesc() {
        return arrangementPlanWithAgencyDesc;
    }

    public void setArrangementPlanWithAgencyDesc(String arrangementPlanWithAgencyDesc) {
        this.arrangementPlanWithAgencyDesc = arrangementPlanWithAgencyDesc;
    }

    public List<ProjectOperationMaintenanceCompletion> getStaffOperationMaintanaceAfterCompletion() {
        return staffOperationMaintanaceAfterCompletion;
    }

    public void setStaffOperationMaintanaceAfterCompletion(List<ProjectOperationMaintenanceCompletion> staffOperationMaintanaceAfterCompletion) {
        this.staffOperationMaintanaceAfterCompletion = staffOperationMaintanaceAfterCompletion;
    }

    public String getEirrAndFirr() {
        return EirrAndFirr;
    }

    public void setEirrAndFirr(String EirrAndFirr) {
        this.EirrAndFirr = EirrAndFirr;
    }

    public String getEnpvAndFnpv() {
        return EnpvAndFnpv;
    }

    public void setEnpvAndFnpv(String EnpvAndFnpv) {
        this.EnpvAndFnpv = EnpvAndFnpv;
    }

    public String getPaybackPeriod() {
        return paybackPeriod;
    }

    public void setPaybackPeriod(String paybackPeriod) {
        this.paybackPeriod = paybackPeriod;
    }

    public double getCostBenefitRatio() {
        return costBenefitRatio;
    }

    public void setCostBenefitRatio(double costBenefitRatio) {
        this.costBenefitRatio = costBenefitRatio;
    }

    public ApplicantProjectProponent getApplicantProjectProponent() {
        return applicantProjectProponent;
    }

    public void setApplicantProjectProponent(ApplicantProjectProponent applicantProjectProponent) {
        this.applicantProjectProponent = applicantProjectProponent;
    }

    public ApplicantMinistryOrProvincialCouncil getApplicantMinistryProvincialCouncil() {
        return applicantMinistryProvincialCouncil;
    }

    public void setApplicantMinistryProvincialCouncil(ApplicantMinistryOrProvincialCouncil applicantMinistryProvincialCouncil) {
        this.applicantMinistryProvincialCouncil = applicantMinistryProvincialCouncil;
    }
    
    
}
