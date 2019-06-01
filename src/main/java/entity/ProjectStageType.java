package entity;

/**
 *
 * @author Dr M H B Ariyaratne
 */
public enum ProjectStageType {
    Awaiting_PEC_Approval,
    @Deprecated
    PEC_Approved,
    PEC_Rejected,
    Awaiting_DNP_Submission,
    Awaiting_DNP_Approval,
    @Deprecated
    DNP_Approved,
    DNP_Rejected,
    Awaiting_Cabinet_Submission,
    Awaiting_Cabinet_Approval,
    Cabinet_Approved,
    Cabinet_Rejected;

    public String getLabel() {
        switch (this) {
            case Awaiting_PEC_Approval:
                return "Awaiting PEC Approval";
            case PEC_Approved:
                return "Approved By PEC";
            case PEC_Rejected:
                return "Rejected by PEC";
            case Awaiting_DNP_Submission:
                return "Awaiting DNP Submission";
            case Awaiting_DNP_Approval:
                return "Awaiting DNP Approval";
            case DNP_Approved:
                return "Approved by DNP";
            case DNP_Rejected:
                return "Rejected by DNP";
            case Awaiting_Cabinet_Submission:
                return "Awaiting Cabinet Submission";
            case Awaiting_Cabinet_Approval:
                return "Awaiting Cabinet Approval";
            case Cabinet_Approved:
                return "Approved by the Cabinet";
            case Cabinet_Rejected:
                return "Rejected by the Cabinet";
            default: return this.toString();
        }
    }
}
