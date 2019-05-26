package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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

    //Editor Properties
    @ManyToOne
    private WebUser lastEditor;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date lastEditAt;

    //Retairing properties
    private boolean retired;
    @ManyToOne
    private WebUser retirer;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date retiredAt;
    @Lob
    private String retireComments;

    
    //PCP Approval
    @ManyToOne
    private WebUser pcpApprovedUser;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pcpApprovedAt;
    @Lob
    private String pcpApprovalRecommendation;

    //PCP Rejection
    @ManyToOne
    private WebUser pcpRejectedUser;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pcpRejectedAt;
    @Lob
    private String pcpRejectRecommendation;
    
    
    
    //Sento to PEC
    @ManyToOne
    private WebUser sentToPec;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sentToPecAt;
    @Lob
    private String sentToPecRecommendation;
    
    //PCE Approval
    @ManyToOne
    private WebUser pecApprovedUser;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pecApprovedAt;
    @Lob
    private String pecApprovalRecommendation;

    //PCE Rejection
    @ManyToOne
    private WebUser pecRejectedUser;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pecRejectedAt;
    @Lob
    private String pecRejectRecommendation;
    
    //Sento to NDP
    @ManyToOne
    private WebUser sentToNdp;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sentToNdpAt;
    @Lob
    private String sentToNdpRecommendation;

    //NDP Approval
    @ManyToOne
    private WebUser ndpApprovedUser;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ndpApprovedAt;
    @Lob
    private String ndpApprovalRecommendation;

    //NDP Rejection
    @ManyToOne
    private WebUser ndpRejectedUser;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ndpRejectedAt;
    @Lob
    private String ndpRejectRecommendation;
    
    //Sento to Cabinet
    @ManyToOne
    private WebUser sentToCabinet;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sentToCabinetAt;
    @Lob
    private String sentToCabinetRecommendation;

    //Cabinet Approval
    @ManyToOne
    private WebUser cabinetApprovedUser;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cabinetApprovedAt;
    @Lob
    private String cabinetApprovalRecommendation;


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

    public WebUser getLastEditor() {
        return lastEditor;
    }

    public void setLastEditor(WebUser lastEditor) {
        this.lastEditor = lastEditor;
    }

    public Date getLastEditAt() {
        return lastEditAt;
    }

    public void setLastEditAt(Date lastEditAt) {
        this.lastEditAt = lastEditAt;
    }

    public WebUser getPcpApprovedUser() {
        return pcpApprovedUser;
    }

    public void setPcpApprovedUser(WebUser pcpApprovedUser) {
        this.pcpApprovedUser = pcpApprovedUser;
    }

    public Date getPcpApprovedAt() {
        return pcpApprovedAt;
    }

    public void setPcpApprovedAt(Date pcpApprovedAt) {
        this.pcpApprovedAt = pcpApprovedAt;
    }

    public String getPcpApprovalRecommendation() {
        return pcpApprovalRecommendation;
    }

    public void setPcpApprovalRecommendation(String pcpApprovalRecommendation) {
        this.pcpApprovalRecommendation = pcpApprovalRecommendation;
    }

    public WebUser getPcpRejectedUser() {
        return pcpRejectedUser;
    }

    public void setPcpRejectedUser(WebUser pcpRejectedUser) {
        this.pcpRejectedUser = pcpRejectedUser;
    }

    public Date getPcpRejectedAt() {
        return pcpRejectedAt;
    }

    public void setPcpRejectedAt(Date pcpRejectedAt) {
        this.pcpRejectedAt = pcpRejectedAt;
    }

    public String getPcpRejectRecommendation() {
        return pcpRejectRecommendation;
    }

    public void setPcpRejectRecommendation(String pcpRejectRecommendation) {
        this.pcpRejectRecommendation = pcpRejectRecommendation;
    }

    public WebUser getSentToPec() {
        return sentToPec;
    }

    public void setSentToPec(WebUser sentToPec) {
        this.sentToPec = sentToPec;
    }

    public Date getSentToPecAt() {
        return sentToPecAt;
    }

    public void setSentToPecAt(Date sentToPecAt) {
        this.sentToPecAt = sentToPecAt;
    }

    public String getSentToPecRecommendation() {
        return sentToPecRecommendation;
    }

    public void setSentToPecRecommendation(String sentToPecRecommendation) {
        this.sentToPecRecommendation = sentToPecRecommendation;
    }

    public WebUser getPecApprovedUser() {
        return pecApprovedUser;
    }

    public void setPecApprovedUser(WebUser pecApprovedUser) {
        this.pecApprovedUser = pecApprovedUser;
    }

    public Date getPecApprovedAt() {
        return pecApprovedAt;
    }

    public void setPecApprovedAt(Date pecApprovedAt) {
        this.pecApprovedAt = pecApprovedAt;
    }

    public String getPecApprovalRecommendation() {
        return pecApprovalRecommendation;
    }

    public void setPecApprovalRecommendation(String pecApprovalRecommendation) {
        this.pecApprovalRecommendation = pecApprovalRecommendation;
    }

    public WebUser getPecRejectedUser() {
        return pecRejectedUser;
    }

    public void setPecRejectedUser(WebUser pecRejectedUser) {
        this.pecRejectedUser = pecRejectedUser;
    }

    public Date getPecRejectedAt() {
        return pecRejectedAt;
    }

    public void setPecRejectedAt(Date pecRejectedAt) {
        this.pecRejectedAt = pecRejectedAt;
    }

    public String getPecRejectRecommendation() {
        return pecRejectRecommendation;
    }

    public void setPecRejectRecommendation(String pecRejectRecommendation) {
        this.pecRejectRecommendation = pecRejectRecommendation;
    }

    public WebUser getSentToNdp() {
        return sentToNdp;
    }

    public void setSentToNdp(WebUser sentToNdp) {
        this.sentToNdp = sentToNdp;
    }

    public Date getSentToNdpAt() {
        return sentToNdpAt;
    }

    public void setSentToNdpAt(Date sentToNdpAt) {
        this.sentToNdpAt = sentToNdpAt;
    }

    public String getSentToNdpRecommendation() {
        return sentToNdpRecommendation;
    }

    public void setSentToNdpRecommendation(String sentToNdpRecommendation) {
        this.sentToNdpRecommendation = sentToNdpRecommendation;
    }

    public WebUser getNdpApprovedUser() {
        return ndpApprovedUser;
    }

    public void setNdpApprovedUser(WebUser ndpApprovedUser) {
        this.ndpApprovedUser = ndpApprovedUser;
    }

    public Date getNdpApprovedAt() {
        return ndpApprovedAt;
    }

    public void setNdpApprovedAt(Date ndpApprovedAt) {
        this.ndpApprovedAt = ndpApprovedAt;
    }

    public String getNdpApprovalRecommendation() {
        return ndpApprovalRecommendation;
    }

    public void setNdpApprovalRecommendation(String ndpApprovalRecommendation) {
        this.ndpApprovalRecommendation = ndpApprovalRecommendation;
    }

    public WebUser getNdpRejectedUser() {
        return ndpRejectedUser;
    }

    public void setNdpRejectedUser(WebUser ndpRejectedUser) {
        this.ndpRejectedUser = ndpRejectedUser;
    }

    public Date getNdpRejectedAt() {
        return ndpRejectedAt;
    }

    public void setNdpRejectedAt(Date ndpRejectedAt) {
        this.ndpRejectedAt = ndpRejectedAt;
    }

    public String getNdpRejectRecommendation() {
        return ndpRejectRecommendation;
    }

    public void setNdpRejectRecommendation(String ndpRejectRecommendation) {
        this.ndpRejectRecommendation = ndpRejectRecommendation;
    }

    public WebUser getSentToCabinet() {
        return sentToCabinet;
    }

    public void setSentToCabinet(WebUser sentToCabinet) {
        this.sentToCabinet = sentToCabinet;
    }

    public Date getSentToCabinetAt() {
        return sentToCabinetAt;
    }

    public void setSentToCabinetAt(Date sentToCabinetAt) {
        this.sentToCabinetAt = sentToCabinetAt;
    }

    public String getSentToCabinetRecommendation() {
        return sentToCabinetRecommendation;
    }

    public void setSentToCabinetRecommendation(String sentToCabinetRecommendation) {
        this.sentToCabinetRecommendation = sentToCabinetRecommendation;
    }

    public WebUser getCabinetApprovedUser() {
        return cabinetApprovedUser;
    }

    public void setCabinetApprovedUser(WebUser cabinetApprovedUser) {
        this.cabinetApprovedUser = cabinetApprovedUser;
    }

    public Date getCabinetApprovedAt() {
        return cabinetApprovedAt;
    }

    public void setCabinetApprovedAt(Date cabinetApprovedAt) {
        this.cabinetApprovedAt = cabinetApprovedAt;
    }

    public String getCabinetApprovalRecommendation() {
        return cabinetApprovalRecommendation;
    }

    public void setCabinetApprovalRecommendation(String cabinetApprovalRecommendation) {
        this.cabinetApprovalRecommendation = cabinetApprovalRecommendation;
    }
    
    

}
