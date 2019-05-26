package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;

@Entity
public class Project implements Serializable {

    static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer projectYear;
    @ManyToOne
    private Area province;
    private String fileNumber;
    @ManyToOne
    private Area district;
    @ManyToOne
    private Institution projectLocation;
    private String projectTitle;
    @Lob
    private String projectDescription;
    private Double projectCost;
    @ManyToOne
    private Item projectCostUnit;
    @ManyToOne
    private Item sourceOfFunds;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date proposalDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pcpFirstReceivedDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pcpLastReceivedDate;

    private Boolean engineersEstimateAvailable;

    private Boolean masterPlanAvailable;

    private Boolean buildingPlanAvailable;

    @Lob
    private String pecRecommendation;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pcpFirstSendToNdpDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pcpLastSendToNdpDate;
    
    
    private Boolean ndbApproved;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ndpApprovedDate;
    
    
    @Lob
    private String ndbRemarks;
    
    
    private Boolean cabinetApproved;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cabinetApprovalDate;
    
    @Lob
    private String remarks;

    @ManyToOne
    private Item sector;
    
    private Boolean allIsland;

    


    @Enumerated(EnumType.STRING)
    private ProjectStageType currentStageType;

    //Created Properties
    @ManyToOne
    private WebUser creater;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdAt;


    //Retairing properties
    private boolean retired;
    @ManyToOne
    private WebUser retirer;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date retiredAt;
    private String retireComments;



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ref No " + fileNumber + " ";
    }

    public Integer getProjectYear() {
        return projectYear;
    }

    public void setProjectYear(Integer projectYear) {
        this.projectYear = projectYear;
    }

    public Institution getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(Institution projectLocation) {
        this.projectLocation = projectLocation;
    }

    public Date getPcpFirstReceivedDate() {
        return pcpFirstReceivedDate;
    }

    public void setPcpFirstReceivedDate(Date pcpFirstReceivedDate) {
        this.pcpFirstReceivedDate = pcpFirstReceivedDate;
    }

    public Date getPcpLastReceivedDate() {
        return pcpLastReceivedDate;
    }

    public void setPcpLastReceivedDate(Date pcpLastReceivedDate) {
        this.pcpLastReceivedDate = pcpLastReceivedDate;
    }

    public Boolean getEngineersEstimateAvailable() {
        return engineersEstimateAvailable;
    }

    public void setEngineersEstimateAvailable(Boolean engineersEstimateAvailable) {
        this.engineersEstimateAvailable = engineersEstimateAvailable;
    }

    public Boolean getMasterPlanAvailable() {
        return masterPlanAvailable;
    }

    public void setMasterPlanAvailable(Boolean masterPlanAvailable) {
        this.masterPlanAvailable = masterPlanAvailable;
    }

    public Boolean getBuildingPlanAvailable() {
        return buildingPlanAvailable;
    }

    public void setBuildingPlanAvailable(Boolean buildingPlanAvailable) {
        this.buildingPlanAvailable = buildingPlanAvailable;
    }

    public String getPecRecommendation() {
        return pecRecommendation;
    }

    public void setPecRecommendation(String pecRecommendation) {
        this.pecRecommendation = pecRecommendation;
    }

    public Date getPcpFirstSendToNdpDate() {
        return pcpFirstSendToNdpDate;
    }

    public void setPcpFirstSendToNdpDate(Date pcpFirstSendToNdpDate) {
        this.pcpFirstSendToNdpDate = pcpFirstSendToNdpDate;
    }

    public Date getPcpLastSendToNdpDate() {
        return pcpLastSendToNdpDate;
    }

    public void setPcpLastSendToNdpDate(Date pcpLastSendToNdpDate) {
        this.pcpLastSendToNdpDate = pcpLastSendToNdpDate;
    }

    public Boolean getNdbApproved() {
        return ndbApproved;
    }

    public void setNdbApproved(Boolean ndbApproved) {
        this.ndbApproved = ndbApproved;
    }

    public Date getNdpApprovedDate() {
        return ndpApprovedDate;
    }

    public void setNdpApprovedDate(Date ndpApprovedDate) {
        this.ndpApprovedDate = ndpApprovedDate;
    }

    public String getNdbRemarks() {
        return ndbRemarks;
    }

    public void setNdbRemarks(String ndbRemarks) {
        this.ndbRemarks = ndbRemarks;
    }

    public Boolean getCabinetApproved() {
        return cabinetApproved;
    }

    public void setCabinetApproved(Boolean cabinetApproved) {
        this.cabinetApproved = cabinetApproved;
    }

    public Date getCabinetApprovalDate() {
        return cabinetApprovalDate;
    }

    public void setCabinetApprovalDate(Date cabinetApprovalDate) {
        this.cabinetApprovalDate = cabinetApprovalDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Area getProvince() {
        return province;
    }

    public void setProvince(Area province) {
        this.province = province;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public Area getDistrict() {
        return district;
    }

    public void setDistrict(Area district) {
        this.district = district;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Double getProjectCost() {
        return projectCost;
    }

    public void setProjectCost(Double projectCost) {
        this.projectCost = projectCost;
    }

    public Item getProjectCostUnit() {
        return projectCostUnit;
    }

    public void setProjectCostUnit(Item projectCostUnit) {
        this.projectCostUnit = projectCostUnit;
    }

    public Item getSourceOfFunds() {
        return sourceOfFunds;
    }

    public void setSourceOfFunds(Item sourceOfFunds) {
        this.sourceOfFunds = sourceOfFunds;
    }

    public Date getProposalDate() {
        return proposalDate;
    }

    public void setProposalDate(Date proposalDate) {
        this.proposalDate = proposalDate;
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

    public ProjectStageType getCurrentStageType() {
        return currentStageType;
    }

    public void setCurrentStageType(ProjectStageType currentStageType) {
        this.currentStageType = currentStageType;
    }

    public WebUser getCreater() {
        return creater;
    }

    public void setCreater(WebUser creater) {
        this.creater = creater;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    public WebUser getRetirer() {
        return retirer;
    }

    public void setRetirer(WebUser retirer) {
        this.retirer = retirer;
    }

    public Date getRetiredAt() {
        return retiredAt;
    }

    public void setRetiredAt(Date retiredAt) {
        this.retiredAt = retiredAt;
    }

    public String getRetireComments() {
        return retireComments;
    }

    public void setRetireComments(String retireComments) {
        this.retireComments = retireComments;
    }

    
    
    

}
