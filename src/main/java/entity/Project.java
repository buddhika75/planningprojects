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

    private String projectTitle;

    @ManyToOne
    private Item sector;
    private Boolean allIsland;
    
    private Area province;
    private Area district;
    private Area dsArea;
    private Area gnArea;
    
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProjectArea> provinces;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProjectArea> districts;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProjectArea> dsDivisions;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProjectArea> gnDivisions;

    @Lob
    private String projectDescription;

    @Enumerated(EnumType.STRING)
    private ProjectStageType currentStageType;

    @ManyToOne
    private Institution originatingInstitution;

    private String fileNumber;

    private Double projectCost;
    @ManyToOne
    private Item projectCostUnit;

    @ManyToOne
    private Item sourceOfFunds;

    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date requestSubmittedAt;

    
    //Booleans
    private boolean cancelled;
    private boolean rejected;
    private boolean reactivated;
    //Created Properties
    @ManyToOne
    private WebUser creater;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdAt;

    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date proposalSubmittedAt;
    @ManyToOne
    private WebUser proposalSubmittedBy;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date proposalAcceptedAt;

    @ManyToOne
    private WebUser editor;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date editedAt;
    //Checking Property
    @ManyToOne
    private WebUser checkedBy;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date checkeAt;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date proposalDate;
    //Retairing properties
    private boolean retired;
    @ManyToOne
    private WebUser retirer;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date retiredAt;
    private String retireComments;
    ////////////////
    @Lob
    private String notes;
    @Lob
    private String specialNotes;
    @Lob
    private String proposal;

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
        if (provinces == null) {
            provinces = new ArrayList<>();
        }
        return provinces;
    }

    public void setProvinces(List<ProjectArea> provinces) {
        this.provinces = provinces;
    }

    public List<ProjectArea> getDistricts() {
        if (districts == null) {
            districts = new ArrayList<>();
        }
        return districts;
    }

    public void setDistricts(List<ProjectArea> districts) {
        this.districts = districts;
    }

    public List<ProjectArea> getDsDivisions() {
        if (dsDivisions == null) {
            dsDivisions = new ArrayList<>();
        }
        return dsDivisions;
    }

    public void setDsDivisions(List<ProjectArea> dsDivisions) {
        this.dsDivisions = dsDivisions;
    }

    public List<ProjectArea> getGnDivisions() {
        if (gnDivisions == null) {
            gnDivisions = new ArrayList<>();
        }
        return gnDivisions;
    }

    public void setGnDivisions(List<ProjectArea> gnDivisions) {
        this.gnDivisions = gnDivisions;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public ProjectStageType getCurrentStageType() {
        return currentStageType;
    }

    public void setCurrentStageType(ProjectStageType currentStageType) {
        this.currentStageType = currentStageType;
    }

    public Institution getOriginatingInstitution() {
        return originatingInstitution;
    }

    public void setOriginatingInstitution(Institution originatingInstitution) {
        this.originatingInstitution = originatingInstitution;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isRejected() {
        return rejected;
    }

    public void setRejected(boolean rejected) {
        this.rejected = rejected;
    }

    public boolean isReactivated() {
        return reactivated;
    }

    public void setReactivated(boolean reactivated) {
        this.reactivated = reactivated;
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

    public WebUser getEditor() {
        return editor;
    }

    public void setEditor(WebUser editor) {
        this.editor = editor;
    }

    public Date getEditedAt() {
        return editedAt;
    }

    public void setEditedAt(Date editedAt) {
        this.editedAt = editedAt;
    }

    public WebUser getCheckedBy() {
        return checkedBy;
    }

    public void setCheckedBy(WebUser checkedBy) {
        this.checkedBy = checkedBy;
    }

    public Date getCheckeAt() {
        return checkeAt;
    }

    public void setCheckeAt(Date checkeAt) {
        this.checkeAt = checkeAt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public Date getRequestSubmittedAt() {
        return requestSubmittedAt;
    }

    public void setRequestSubmittedAt(Date requestSubmittedAt) {
        this.requestSubmittedAt = requestSubmittedAt;
    }

    public String getProposal() {
        if (proposal == null) {
            proposal = "";
        }
        return proposal;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal;
    }

    public Date getProposalSubmittedAt() {
        return proposalSubmittedAt;
    }

    public void setProposalSubmittedAt(Date proposalSubmittedAt) {
        this.proposalSubmittedAt = proposalSubmittedAt;
    }

    public WebUser getProposalSubmittedBy() {
        return proposalSubmittedBy;
    }

    public void setProposalSubmittedBy(WebUser proposalSubmittedBy) {
        this.proposalSubmittedBy = proposalSubmittedBy;
    }

    public Date getProposalAcceptedAt() {
        return proposalAcceptedAt;
    }

    public void setProposalAcceptedAt(Date proposalAcceptedAt) {
        this.proposalAcceptedAt = proposalAcceptedAt;
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

    public Area getProvince() {
        return province;
    }

    public void setProvince(Area province) {
        this.province = province;
    }

    public Area getDistrict() {
        return district;
    }

    public void setDistrict(Area district) {
        this.district = district;
    }

    public Area getDsArea() {
        return dsArea;
    }

    public void setDsArea(Area dsArea) {
        this.dsArea = dsArea;
    }

    public Area getGnArea() {
        return gnArea;
    }

    public void setGnArea(Area gnArea) {
        this.gnArea = gnArea;
    }

    
    
}
