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
import javax.persistence.Transient;

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

    private Boolean pecApproved;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pecApprovedDate;

    private Boolean pecRejected;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pecRejectedDate;

    private Boolean dnpSubmitted;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dnpSubmittedDate;

    private Boolean dnpApproved;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dnpApprovedDate;

    private Boolean dnpRejected;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dnpRejectedDate;

    private Boolean cabinetSubmitted;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cabinetSubmittedDate;

    private Boolean cabinetApproved;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cabinetApprovalDate;

    private Boolean cabinetRejected;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cabinetRejectedDate;

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

    //Sento to DNP
    @ManyToOne
    private WebUser dnpSubmissionUser;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dnpSubmissionAt;
    @Lob
    private String dnpSubmissionRecommendation;

    //DNP Approval
    @ManyToOne
    private WebUser dnpApprovedUser;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dnpApprovedAt;
    @Lob
    private String dnpApprovalRecommendation;

    //DNP Rejection
    @ManyToOne
    private WebUser dnpRejectedUser;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dnpRejectedAt;
    @Lob
    private String dnpRejectRecommendation;

    //Sento to Cabinet
    @ManyToOne
    private WebUser cabinetSubmissionUser;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cabinetSubmissionAt;
    @Lob
    private String cabinetSubmissionRecommendation;

    //Cabinet Approval
    @ManyToOne
    private WebUser cabinetApprovedUser;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cabinetApprovedAt;
    @Lob
    private String cabinetApprovalRecommendation;

    //Cabinet Rejection
    @ManyToOne
    private WebUser cabinetRejectedUser;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cabinetRejectedAt;
    @Lob
    private String cabinetRejectRecommendation;

    @Transient
    private boolean canApproveAtPec = false;
    @Transient
    private boolean canRejectAtPec = false;

    @Transient
    private boolean canSubmitToDnp;
    @Transient
    private boolean canApproveAtDnp = false;
    @Transient
    private boolean canRejectAtDnp = false;

    @Transient
    private boolean canSubmitToCabinet;
    @Transient
    private boolean canApproveAtCabinet = false;
    @Transient
    private boolean canRejectAtCabinet = false;

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

    public Boolean getDnpApproved() {
        return dnpApproved;
    }

    public void setDnpApproved(Boolean dnpApproved) {
        this.dnpApproved = dnpApproved;
    }

    public Date getDnpApprovedDate() {
        return dnpApprovedDate;
    }

    public void setDnpApprovedDate(Date dnpApprovedDate) {
        this.dnpApprovedDate = dnpApprovedDate;
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

    public WebUser getDnpSubmissionUser() {
        return dnpSubmissionUser;
    }

    public void setDnpSubmissionUser(WebUser dnpSubmissionUser) {
        this.dnpSubmissionUser = dnpSubmissionUser;
    }

    public Date getDnpSubmissionAt() {
        return dnpSubmissionAt;
    }

    public void setDnpSubmissionAt(Date dnpSubmissionAt) {
        this.dnpSubmissionAt = dnpSubmissionAt;
    }

    public String getDnpSubmissionRecommendation() {
        return dnpSubmissionRecommendation;
    }

    public void setDnpSubmissionRecommendation(String dnpSubmissionRecommendation) {
        this.dnpSubmissionRecommendation = dnpSubmissionRecommendation;
    }

    public WebUser getDnpApprovedUser() {
        return dnpApprovedUser;
    }

    public void setDnpApprovedUser(WebUser dnpApprovedUser) {
        this.dnpApprovedUser = dnpApprovedUser;
    }

    public Date getDnpApprovedAt() {
        return dnpApprovedAt;
    }

    public void setDnpApprovedAt(Date dnpApprovedAt) {
        this.dnpApprovedAt = dnpApprovedAt;
    }

    public String getDnpApprovalRecommendation() {
        return dnpApprovalRecommendation;
    }

    public void setDnpApprovalRecommendation(String dnpApprovalRecommendation) {
        this.dnpApprovalRecommendation = dnpApprovalRecommendation;
    }

    public WebUser getDnpRejectedUser() {
        return dnpRejectedUser;
    }

    public void setDnpRejectedUser(WebUser dnpRejectedUser) {
        this.dnpRejectedUser = dnpRejectedUser;
    }

    public Date getDnpRejectedAt() {
        return dnpRejectedAt;
    }

    public void setDnpRejectedAt(Date dnpRejectedAt) {
        this.dnpRejectedAt = dnpRejectedAt;
    }

    public String getDnpRejectRecommendation() {
        return dnpRejectRecommendation;
    }

    public void setDnpRejectRecommendation(String dnpRejectRecommendation) {
        this.dnpRejectRecommendation = dnpRejectRecommendation;
    }

    public WebUser getCabinetSubmissionUser() {
        return cabinetSubmissionUser;
    }

    public void setCabinetSubmissionUser(WebUser cabinetSubmissionUser) {
        this.cabinetSubmissionUser = cabinetSubmissionUser;
    }

    public Date getCabinetSubmissionAt() {
        return cabinetSubmissionAt;
    }

    public void setCabinetSubmissionAt(Date cabinetSubmissionAt) {
        this.cabinetSubmissionAt = cabinetSubmissionAt;
    }

    public String getCabinetSubmissionRecommendation() {
        return cabinetSubmissionRecommendation;
    }

    public void setCabinetSubmissionRecommendation(String cabinetSubmissionRecommendation) {
        this.cabinetSubmissionRecommendation = cabinetSubmissionRecommendation;
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

    public Boolean getPecApproved() {
        return pecApproved;
    }

    public void setPecApproved(Boolean pecApproved) {
        this.pecApproved = pecApproved;
    }

    public Date getPecApprovedDate() {
        return pecApprovedDate;
    }

    public void setPecApprovedDate(Date pecApprovedDate) {
        this.pecApprovedDate = pecApprovedDate;
    }

    public Boolean getPecRejected() {
        return pecRejected;
    }

    public void setPecRejected(Boolean pecRejected) {
        this.pecRejected = pecRejected;
    }

    public Date getPecRejectedDate() {
        return pecRejectedDate;
    }

    public void setPecRejectedDate(Date pecRejectedDate) {
        this.pecRejectedDate = pecRejectedDate;
    }

    public Boolean getDnpRejected() {
        return dnpRejected;
    }

    public void setDnpRejected(Boolean dnpRejected) {
        this.dnpRejected = dnpRejected;
    }

    public Date getDnpRejectedDate() {
        return dnpRejectedDate;
    }

    public void setDnpRejectedDate(Date dnpRejectedDate) {
        this.dnpRejectedDate = dnpRejectedDate;
    }

    public Boolean getDnpSubmitted() {
        return dnpSubmitted;
    }

    public void setDnpSubmitted(Boolean dnpSubmitted) {
        this.dnpSubmitted = dnpSubmitted;
    }

    public Date getDnpSubmittedDate() {
        return dnpSubmittedDate;
    }

    public void setDnpSubmittedDate(Date dnpSubmittedDate) {
        this.dnpSubmittedDate = dnpSubmittedDate;
    }

    public WebUser getPecApprovedUser() {
        return pecApprovedUser;
    }

    public Boolean getCabinetSubmitted() {
        return cabinetSubmitted;
    }

    public void setCabinetSubmitted(Boolean cabinetSubmitted) {
        this.cabinetSubmitted = cabinetSubmitted;
    }

    public Date getCabinetSubmittedDate() {
        return cabinetSubmittedDate;
    }

    public void setCabinetSubmittedDate(Date cabinetSubmittedDate) {
        this.cabinetSubmittedDate = cabinetSubmittedDate;
    }

    public WebUser getCabinetRejectedUser() {
        return cabinetRejectedUser;
    }

    public void setCabinetRejectedUser(WebUser cabinetRejectedUser) {
        this.cabinetRejectedUser = cabinetRejectedUser;
    }

    public Date getCabinetRejectedAt() {
        return cabinetRejectedAt;
    }

    public void setCabinetRejectedAt(Date cabinetRejectedAt) {
        this.cabinetRejectedAt = cabinetRejectedAt;
    }

    
    
    
    public String getCabinetRejectRecommendation() {
        return cabinetRejectRecommendation;
    }

    public void setCabinetRejectRecommendation(String cabinetRejectRecommendation) {
        this.cabinetRejectRecommendation = cabinetRejectRecommendation;
    }

    public boolean isCanApproveAtPec() {
        if (currentStageType == ProjectStageType.Awaiting_PEC_Approval) {
            canApproveAtPec = true;
        } else {
            canApproveAtPec = false;
        }
        return canApproveAtPec;
    }

    public boolean isCanRejectAtPec() {
        if (currentStageType == ProjectStageType.Awaiting_PEC_Approval) {
            canRejectAtPec = true;
        } else {
            canRejectAtPec = false;
        }
        return canRejectAtPec;
    }

    public boolean isCanSubmitToDnp() {
        if (currentStageType == ProjectStageType.Awaiting_DNP_Submission) {
            canSubmitToDnp = true;
        } else {
            canSubmitToDnp = false;
        }
        return canSubmitToDnp;
    }

    public boolean isCanApproveAtDnp() {
        if (currentStageType == ProjectStageType.Awaiting_DNP_Approval) {
            canApproveAtDnp = true;
        } else {
            canApproveAtDnp = false;
        }
        return canApproveAtDnp;
    }

    public boolean isCanRejectAtDnp() {
        if (currentStageType == ProjectStageType.Awaiting_DNP_Approval) {
            canRejectAtDnp = true;
        } else {
            canRejectAtDnp = false;
        }
        return canRejectAtDnp;
    }

    public boolean isCanSubmitToCabinet() {
        if (currentStageType == ProjectStageType.Awaiting_Cabinet_Submission) {
            canSubmitToCabinet = true;
        } else {
            canSubmitToCabinet = false;
        }
        return canSubmitToCabinet;
    }

    public boolean isCanApproveAtCabinet() {
        if (currentStageType == ProjectStageType.Awaiting_Cabinet_Approval) {
            canApproveAtCabinet = true;
        } else {
            canApproveAtCabinet = false;
        }
        return canApproveAtCabinet;
    }

    public boolean isCanRejectAtCabinet() {
        if (currentStageType == ProjectStageType.Awaiting_Cabinet_Approval) {
            canRejectAtCabinet = true;
        } else {
            canRejectAtCabinet = false;
        }
        return canRejectAtCabinet;
    }

    public Boolean getCabinetRejected() {
        return cabinetRejected;
    }

    public void setCabinetRejected(Boolean cabinetRejected) {
        this.cabinetRejected = cabinetRejected;
    }

    public Date getCabinetRejectedDate() {
        return cabinetRejectedDate;
    }

    public void setCabinetRejectedDate(Date cabinetRejectedDate) {
        this.cabinetRejectedDate = cabinetRejectedDate;
    }

}
