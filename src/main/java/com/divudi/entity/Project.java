package com.divudi.entity;

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

    @Lob
    private String comments;

    @Enumerated(EnumType.STRING)
    private ProjectStageType currentStageType;

    @ManyToOne
    private Institution client;

    private String referenceNo;

    //Booleans
    private boolean cancelled;
    private boolean refunded;
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
    private String twelveMonthsElectricityUsage;
    @Lob
    private String specialNotes;
    @Lob
    private String proposal;

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

    public Institution getClient() {
        return client;
    }

    public void setClient(Institution client) {
        this.client = client;
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

    public boolean isRefunded() {
        return refunded;
    }

    public void setRefunded(boolean refunded) {
        this.refunded = refunded;
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

    public String getTwelveMonthsElectricityUsage() {
        return twelveMonthsElectricityUsage;
    }

    public void setTwelveMonthsElectricityUsage(String twelveMonthsElectricityUsage) {
        this.twelveMonthsElectricityUsage = twelveMonthsElectricityUsage;
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
