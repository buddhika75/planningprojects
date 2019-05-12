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
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProjectArea> provinces;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProjectArea> districts;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProjectArea> dsDivisions;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProjectArea> gnDivisions;
    @ManyToOne
    
    
    
    @Lob
    private String comments;

    @Enumerated(EnumType.STRING)
    private ProjectStageType currentStageType;

    @ManyToOne
    private Institution originatingInstitution;

    private String referenceNo;

    //Booleans
    private boolean cancelled;
    private boolean rejected;
    private boolean reactivated;
    //Created Properties
    @ManyToOne
    private WebUser creater;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdAt;
    //Edited Properties
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date requestSubmittedAt;

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
        if(provinces==null){
            provinces = new ArrayList<>();
        }
        return provinces;
    }

    public void setProvinces(List<ProjectArea> provinces) {
        this.provinces = provinces;
    }

    public List<ProjectArea> getDistricts() {
         if(districts==null){
            districts = new ArrayList<>();
        }
        return districts;
    }

    public void setDistricts(List<ProjectArea> districts) {
        this.districts = districts;
    }

    public List<ProjectArea> getDsDivisions() {
         if(dsDivisions==null){
            dsDivisions = new ArrayList<>();
        }
        return dsDivisions;
    }

    public void setDsDivisions(List<ProjectArea> dsDivisions) {
        this.dsDivisions = dsDivisions;
    }

    public List<ProjectArea> getGnDivisions() {
         if(gnDivisions==null){
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
        return "Ref No " + referenceNo + " ";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
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


    

}
