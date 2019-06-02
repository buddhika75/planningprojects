package bean;

import entity.Area;
import entity.AreaType;
import entity.WebUser;

import entity.Institution;
import entity.InstitutionType;
import entity.Item;
import entity.ItemType;
import entity.Project;
import entity.ProjectArea;
import entity.ProjectStageType;
import entity.Upload;
import entity.UploadType;
import entity.WebUserRole;
import facade.InstitutionFacade;
import facade.ProjectAreaFacade;
import facade.ProjectFacade;
import facade.UploadFacade;
import facade.WebUserFacade;
import facade.util.JsfUtil;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.persistence.TemporalType;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@Named("webUserController")
@SessionScoped
public class WebUserController implements Serializable {

    /*
    EJBs
     */
    @EJB
    private facade.WebUserFacade ejbFacade;
    @EJB
    private InstitutionFacade institutionFacade;
    @EJB
    private ProjectFacade projectFacade;
    @EJB
    private UploadFacade uploadFacade;
    @EJB
    private ProjectAreaFacade projectAreaFacade;

    /*
    Controllers
     */
    @Inject
    private CommonController commonController;
    @Inject
    private AreaController areaController;
    @Inject
    private InstitutionController institutionController;
    @Inject
    private ItemController itemController;

    /*
    Variables
     */
    private List<WebUser> items = null;
    private List<Upload> currentProjectUploads;
    private List<Upload> clientUploads;
    private List<Upload> companyUploads;
    private List<Project> listOfProjects;

    private Area[] selectedProvinces;
    private List<Area> selectedDistricts;
    private List<Area> selectedDsAreas;
    private List<Area> selectedGnAreas;

    private ProjectArea selectedProjectArea;

    private WebUser current;
    private Project currentProject;
    private Upload currentUpload;
    private Institution institution;

    private WebUser loggedUser;
    private String userName;
    private String password;
    private MapModel emptyModel;

    private UploadedFile file;
    private String comments;

    private StreamedContent downloadingFile;

    private Date fromDate;
    private Date toDate;

    private Integer year;
    private Area province;
    private Area district;
    private Institution location;
    private Boolean allIslandProjects;
    private String searchKeyword;

    private String loginRequestResponse;

    private String locale;

    @PostConstruct
    public void init() {
        emptyModel = new DefaultMapModel();
    }

    public void removeSelectedProvince() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to add");
            return;
        }
        if (selectedProjectArea == null) {
            JsfUtil.addErrorMessage("Nothing to add");
            return;
        }
        try {
//            currentProject.getProvinces().remove(selectedProjectArea);
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Error. " + e.getMessage());
        }
    }

    public void addSelectedProvincesToProject() {
        System.out.println("addSelectedProvincesToProject");
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to add");
            return;
        }
        for (Area a : selectedProvinces) {
//            boolean alreadyAdded=false;
//            for(ProjectArea pa: currentProject.getProvinces()){
//                if(pa.getArea().equals(a)){
//                    alreadyAdded= true;
//                }
//            }
//            System.out.println("alreadyAdded = " + alreadyAdded);
//            if(!alreadyAdded){
//                ProjectArea pa = new ProjectArea();
//                pa.setProject(currentProject);
//                pa.setArea(a);
//                projectAreaFacade.create(pa); 
//                getCurrentProject().getProvinces().add(pa);
//                System.out.println("added");
//            }
        }
        selectedProvinces = null;
    }

    public void removeSelectedDistrict() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to add");
            return;
        }
        if (selectedProjectArea == null) {
            JsfUtil.addErrorMessage("Nothing to add");
            return;
        }
        try {
//            currentProject.getDistricts().remove(selectedProjectArea);
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Error. " + e.getMessage());
        }
    }

    public void addSelectedDistrictToProject() {
        System.out.println("addSelectedProvincesToProject");
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to add");
            return;
        }
        for (Area a : selectedDistricts) {
            boolean alreadyAdded = false;
//            for(ProjectArea pa: currentProject.getDistricts()){
//                if(pa.getArea().equals(a)){
//                    alreadyAdded= true;
//                }
//            }
            System.out.println("alreadyAdded = " + alreadyAdded);
            if (!alreadyAdded) {
                ProjectArea pa = new ProjectArea();
                pa.setProject(currentProject);
                pa.setArea(a);
                projectAreaFacade.create(pa);
//                getCurrentProject().getDistricts().add(pa);
                System.out.println("added");
            }
        }
        selectedDistricts = null;
    }

    public void removeSelectedDsArea() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to add");
            return;
        }
        if (selectedProjectArea == null) {
            JsfUtil.addErrorMessage("Nothing to add");
            return;
        }
        try {
//            currentProject.getDsDivisions().remove(selectedProjectArea);
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Error. " + e.getMessage());
        }
    }

    public void addSelectedDsDivisionToProject() {
        System.out.println("addSelectedProvincesToProject");
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to add");
            return;
        }
        for (Area a : selectedDsAreas) {
            boolean alreadyAdded = false;
//            for(ProjectArea pa: currentProject.getDsDivisions()){
//                if(pa.getArea().equals(a)){
//                    alreadyAdded= true;
//                }
//            }
            System.out.println("alreadyAdded = " + alreadyAdded);
            if (!alreadyAdded) {
                ProjectArea pa = new ProjectArea();
                pa.setProject(currentProject);
                pa.setArea(a);
                projectAreaFacade.create(pa);
//                getCurrentProject().getDsDivisions().add(pa);
                System.out.println("added");
            }
        }
        selectedDsAreas = null;
    }

    public void removeSelectedGn() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to add");
            return;
        }
        if (selectedProjectArea == null) {
            JsfUtil.addErrorMessage("Nothing to add");
            return;
        }
        try {
//            currentProject.getGnDivisions().remove(selectedProjectArea);
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Error. " + e.getMessage());
        }
    }

    public void addSelectedGnAreasToProject() {
        System.out.println("addSelectedProvincesToProject");
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to add");
            return;
        }
        for (Area a : selectedGnAreas) {
            boolean alreadyAdded = false;
//            for(ProjectArea pa: currentProject.getGnDivisions()){
//                if(pa.getArea().equals(a)){
//                    alreadyAdded= true;
//                }
//            }
            System.out.println("alreadyAdded = " + alreadyAdded);
            if (!alreadyAdded) {
                ProjectArea pa = new ProjectArea();
                pa.setProject(currentProject);
                pa.setArea(a);
//                projectAreaFacade.create(pa); 
//                getCurrentProject().getGnDivisions().add(pa);
                System.out.println("added");
            }
        }
        selectedGnAreas = null;
    }

    public String listProjectsToSubmitBids() {
        listProjectsToSubmitBids(getLoggedUser().getInstitution());
        return "/list_for_providers";
    }

    public void listProjectsToSubmitBids(Institution provider) {
        List<Project> ps = listProjects(ProjectStageType.Awaiting_DNP_Approval);
        listOfProjects = new ArrayList<>();
    }

    public String listAllProjects() {
        allIslandProjects = false;
        listOfProjects = listProjects();
        return "/project_lists";
    }

    public String listProjectsAwaitingPecApproval() {
        listOfProjects = listProjects(ProjectStageType.Awaiting_PEC_Approval);
        return "/project_lists";
    }

    public String listProjectsPecRejected() {
        listOfProjects = listProjects(ProjectStageType.PEC_Rejected);
        return "/project_lists";
    }

    public String listProjectsAwaitingDnpSubmission() {
        listOfProjects = listProjects(ProjectStageType.Awaiting_DNP_Submission);
        return "/project_lists";
    }

    public String listProjectsAwaitingDnpApproval() {
        listOfProjects = listProjects(ProjectStageType.Awaiting_DNP_Approval);
        return "/project_lists";
    }

    public String listProjectsDnpRejected() {
        listOfProjects = listProjects(ProjectStageType.DNP_Rejected);
        return "/project_lists";
    }

    public String listProjectsAwaitingCabinetSubmission() {
        listOfProjects = listProjects(ProjectStageType.Awaiting_Cabinet_Submission);
        return "/project_lists";
    }

    public String listProjectsAwaitingCabinetApproval() {
        listOfProjects = listProjects(ProjectStageType.Awaiting_Cabinet_Approval);
        return "/project_lists";
    }

    public String listProjectsCabinetRejected() {
        listOfProjects = listProjects(ProjectStageType.Cabinet_Rejected);
        return "/project_lists";
    }

    public String listProjectsCabinetApproved() {
        listOfProjects = listProjects(ProjectStageType.Cabinet_Approved);
        return "/project_lists";
    }

    public String listProjectsOngoing() {
        listOfProjects = listProjects(ProjectStageType.Ongoing);
        return "/project_lists";
    }

    public String listProjectsCompleted() {
        listOfProjects = listProjects(ProjectStageType.Completed);
        return "/project_lists";
    }

    public String searchAllIslandProjects() {
        allIslandProjects = true;
        listOfProjects = listProjects(null, year, true, null, null);
        return "/projects_search_all_island";
    }

    public String searchAllIslandProjectsMobile() {
        allIslandProjects = true;
        listOfProjects = listProjects(null, year, true, null, null);
        return "/mobile/projects_search_all_island";
    }

    public String searchProjectsByProvince() {
        allIslandProjects = false;
        if (province != null) {
            String j = "select p from Project p where p.province=:province ";
            Map m = new HashMap();
            if (year != null) {
                j += " and p.projectYear=:y ";
                m.put("y", year);
            }
            j += " order by p.id";

            m.put("province", province);
            listOfProjects = getProjectFacade().findBySQL(j, m);
        } else {
            listOfProjects = null;
        }
        return "/projects_search_by_province";
    }

    public String searchProjectsByDistrict() {
        allIslandProjects = false;
        if (district != null) {
            String j = "select p from Project p where p.district=:district ";
            Map m = new HashMap();
            if (year != null) {
                j += " and p.projectYear=:y ";
                m.put("y", year);
            }
            j += " order by p.id";

            m.put("district", district);
            listOfProjects = getProjectFacade().findBySQL(j, m);
        } else {
            listOfProjects = null;
        }
        return "/projects_search_by_district";
    }

    public String searchProjectsByTitle() {
        allIslandProjects = false;
        if (searchKeyword != null && !searchKeyword.trim().equals("")) {
            String j = "select p from Project p where lower(p.projectTitle) like :fn ";
            Map m = new HashMap();
            if (year != null) {
                j += " and p.projectYear=:y ";
                m.put("y", year);
            }
            j += " order by p.id";

            m.put("fn", "%" + searchKeyword.trim().toLowerCase() + "%");
            listOfProjects = getProjectFacade().findBySQL(j, m);
        } else {
            listOfProjects = null;
        }
        return "/projects_search_by_title";
    }

    public String searchProjectsByFileNumber() {
        allIslandProjects = false;
        if (searchKeyword != null && !searchKeyword.trim().equals("")) {
            String j = "select p from Project p where lower(p.fileNumber) like :fn ";
            Map m = new HashMap();
            if (year != null) {
                j += " and p.projectYear=:y ";
                m.put("y", year);
            }
            j += " order by p.id";

            m.put("fn", "%" + searchKeyword.trim().toLowerCase() + "%");
            listOfProjects = getProjectFacade().findBySQL(j, m);
        } else {
            listOfProjects = null;
        }
        return "/projects_search_by_file_number";
    }

    public String searchProjects() {
        listOfProjects = null;
        return "/project_search";
    }

    public List<Project> listProjects(ProjectStageType type) {
        Calendar c = Calendar.getInstance();
        c.setTime(getToDate());
        c.add(Calendar.DATE, 2);
        String j = "select p from Project p "
                + " where p.currentStageType=:t "
                + " order by p.id";
        Map m = new HashMap();
        m.put("t", type);
        return getProjectFacade().findBySQL(j, m, TemporalType.DATE);
    }

    public List<Project> listProjects(ProjectStageType type, Integer y, Boolean allIsland, Area province, Area district, String titleSearchQry) {
        return listProjects(type, y, allIsland, province, district, titleSearchQry, null);

    }

    public List<Project> listProjects(ProjectStageType type, Integer y, Boolean allIsland, Area province, Area district, String titleSearchQry, String fileNo) {
        Calendar c = Calendar.getInstance();
        c.setTime(getToDate());
        c.add(Calendar.DATE, 2);
        String j = "select p from Project p "
                + " where p.id <> :f ";

        Map m = new HashMap();
        m.put("f", 0);

        if (type != null) {
            j += " and p.currentStageType=:t ";
            m.put("t", type);
        }

        if (y != null) {
            j += " and p.projectYear=:y ";
            m.put("y", y);
        }

        if (allIsland != null) {
            j += " and p.allIsland=:a ";
            m.put("a", allIsland);
        }

        if (province != null) {
            j += " and p.province=:p ";
            m.put("p", province);
        }

        if (district != null) {
            j += " and p.district=:d ";
            m.put("d", district);
        }

        if (titleSearchQry != null && !titleSearchQry.trim().equals("")) {
            j += " and lower(p.projectTitle) like :tq ";
            m.put("tq", "%" + titleSearchQry.trim().toLowerCase() + "%");
        }

        if (fileNo != null && !fileNo.trim().equals("")) {
            j += " and lower(p.fileNumber) like :fn ";
            m.put("fn", "%" + fileNo.trim().toLowerCase() + "%");
        }

        j += " order by p.id";

        System.out.println("m = " + m);
        System.out.println("j = " + j);

        return getProjectFacade().findBySQL(j, m, TemporalType.DATE);
    }

    public List<Project> listProjects(ProjectStageType type, Integer y, Boolean allIsland, Area province, Area district) {
        return listProjects(type, y, allIsland, province, district, null, null);
    }

    public List<Project> listProjects() {
        Calendar c = Calendar.getInstance();
        c.setTime(getToDate());
        c.add(Calendar.DATE, 2);
        String j = "select p from Project p "
                + " order by p.id";
        return getProjectFacade().findBySQL(j);
    }

    public String viewProject() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Please select a project");
            return "";
        }
        current = currentProject.getCreater();
        currentProjectUploads = null;
        companyUploads = null;
        clientUploads = null;
        currentUpload = null;
        markLocationOnMap();
        return "/project";
    }

    public String viewMyProject() {
        if (loggedUser == null) {
            JsfUtil.addErrorMessage("Please login to continue");
            return "";
        }
        current = loggedUser;
        currentProject = getLastProject(current);
        currentProjectUploads = null;
        companyUploads = null;
        clientUploads = null;
        currentUpload = null;

        markLocationOnMap();
        return "/project_client_view_after_submission";
    }

    public void markLocationOnMap() {
        emptyModel = new DefaultMapModel();
        if (current == null) {
            return;
        }
        LatLng coord1 = new LatLng(current.getInstitution().getCoordinate().getLatitude(), current.getInstitution().getCoordinate().getLongitude());
        emptyModel.addOverlay(new Marker(coord1, current.getInstitution().getAddress()));
    }

    public void markLocationOnMapForBidders() {
        emptyModel = new DefaultMapModel();
        if (current == null) {
            return;
        }
        LatLng coord1 = new LatLng(current.getInstitution().getCoordinate().getLatitude(), current.getInstitution().getCoordinate().getLongitude());
        emptyModel.addOverlay(new Marker(coord1, current.getInstitution().getAddress()));
    }

    public String viewMedia() {
        if (currentUpload == null) {
            JsfUtil.addErrorMessage("Nothing is selected to view");
            return "";
        }
        if (currentUpload.getFileType().contains("image")) {
            return "/view_image";
        } else if (currentUpload.getFileType().contains("pdf")) {
            return "/view_pdf";
        } else {
            JsfUtil.addErrorMessage("NOT an image of a pdf file. ");
            return "";
        }
    }

    public Project getLastProject(WebUser webUser) {
        String j = "Select p from Project p "
                + " where p.client=:ins "
                + " order by p.id desc";
        Map m = new HashMap();
        m.put("ins", webUser.getInstitution());
        return getProjectFacade().findFirstBySQL(j, m);
    }

    public String toSubmitClientRequest() {
        return "/finalize_client_request";
    }

    public String submitClientRequest() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Please refresh and login to system to submit.");
            return "";
        }
//        currentProject.setRequestSubmittedAt(new Date());
        currentProject.setCurrentStageType(ProjectStageType.Awaiting_PEC_Approval);
        getProjectFacade().edit(currentProject);
        sendSubmitClientRequestConfirmationEmail();
        JsfUtil.addSuccessMessage("Project Successfully Submitted");
        markLocationOnMap();
        return "/project_client_view_after_submission";
    }

    public void sendSubmitClientRequestConfirmationEmail() {

    }

    public void downloadCurrentFile() {
        if (currentUpload == null) {
            return;
        }
        InputStream stream = new ByteArrayInputStream(currentUpload.getBaImage());
        downloadingFile = new DefaultStreamedContent(stream, currentUpload.getFileType(), currentUpload.getFileName());
    }

    public StreamedContent getDownloadingFile() {
        downloadCurrentFile();
        return downloadingFile;
    }

    public String addMarker() {
        Marker marker = new Marker(new LatLng(current.getInstitution().getCoordinate().getLatitude(), current.getInstitution().getCoordinate().getLongitude()), current.getName());
        emptyModel.addOverlay(marker);
        getInstitutionFacade().edit(getCurrent().getInstitution());
        JsfUtil.addSuccessMessage("Location Recorded");
        return addNewProject();
    }

    public String addNewProject() {
        currentProject = new Project();
        currentProject.setProjectTitle("");
        Calendar c = Calendar.getInstance();
        currentProject.setProjectYear(c.get(Calendar.YEAR));
        currentProject.setCreater(loggedUser);
        currentProject.setCreatedAt(new Date());
        currentProject.setCurrentStageType(ProjectStageType.Awaiting_PEC_Approval);
        return "/project";
    }

    public void updateProject() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to update");
            return;
        }
        if (currentProject.getId() == null) {
            currentProject.setCurrentStageType(ProjectStageType.Awaiting_PEC_Approval);
            currentProject.setCreatedAt(new Date());
            currentProject.setCreater(loggedUser);
            getProjectFacade().create(currentProject);
            JsfUtil.addSuccessMessage("Saved");
        } else {
            currentProject.setLastEditAt(new Date());
            currentProject.setLastEditor(loggedUser);
            getProjectFacade().edit(currentProject);
            JsfUtil.addSuccessMessage("Updated");
        }

    }

    /**
     *
     *
     *
     *
     *
     * Navigating to Mark
     *
     *
     *
     *
     *
     *
     */
    public String toPecApproval() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to update");
            return "";
        }
        currentProject.setPecApprovedDate(new Date());
        getProjectFacade().edit(currentProject);
        return "/pec_approval";
    }

    public String toPecRejection() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to update");
            return "";
        }
        currentProject.setPecRejectedDate(new Date());
        getProjectFacade().edit(currentProject);
        return "/pec_rejection";
    }

    public String toDnpSubmission() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to update");
            return "";
        }
        currentProject.setDnpSubmittedDate(new Date());
        getProjectFacade().edit(currentProject);
        return "/dnp_submission";
    }

    public String toDnpApproval() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to update");
            return "";
        }
        currentProject.setDnpApprovedDate(new Date());
        getProjectFacade().edit(currentProject);
        return "/dnp_approval";
    }

    public String toDnpRejection() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to update");
            return "";
        }
        currentProject.setDnpRejectedDate(new Date());
        getProjectFacade().edit(currentProject);
        return "/dnp_rejection";
    }

    public String toCabinetSubmission() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to update");
            return "";
        }
        currentProject.setCabinetSubmittedDate(new Date());
        getProjectFacade().edit(currentProject);
        return "/cabinet_submission";
    }

    public String toCabinetApproval() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to update");
            return "";
        }
        currentProject.setCabinetApprovalDate(new Date());
        getProjectFacade().edit(currentProject);
        return "/cabinet_approval";
    }

    public String toCabinetRejection() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to update");
            return "";
        }
        currentProject.setCabinetRejectedDate(new Date());
        getProjectFacade().edit(currentProject);
        return "/cabinet_rejection";
    }

    /**
     *
     *
     *
     *
     *
     * Marking
     *
     *
     *
     *
     *
     *
     */
    public void markAsPecApproved() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing selected");
            return;
        }
        getCurrentProject().setCurrentStageType(ProjectStageType.Awaiting_DNP_Submission);
        getCurrentProject().setPecApprovedUser(loggedUser);
        getCurrentProject().setPecApprovedAt(new Date());
        getCurrentProject().setPecApproved(true);
        getProjectFacade().edit(currentProject);
        JsfUtil.addSuccessMessage("Marked as PEC Approved.");
    }

    public void markAsPecRejected() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing selected");
            return;
        }
        getCurrentProject().setCurrentStageType(ProjectStageType.PEC_Rejected);
        getCurrentProject().setPecRejectedUser(loggedUser);
        getCurrentProject().setPecRejectedAt(new Date());
        getCurrentProject().setPecRejected(true);
        getProjectFacade().edit(currentProject);
        JsfUtil.addSuccessMessage("Marked as Rejected by PEC.");
    }

    public void markAsSubmittedToDnp() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing selected");
            return;
        }
        getCurrentProject().setCurrentStageType(ProjectStageType.Awaiting_DNP_Approval);
        getCurrentProject().setDnpSubmissionUser(loggedUser);
        getCurrentProject().setDnpSubmissionAt(new Date());
        getCurrentProject().setDnpSubmitted(true);
        getProjectFacade().edit(currentProject);
        JsfUtil.addSuccessMessage("Marked as Submitted to DNP.");
    }

    public void markAsDnpApproved() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing selected");
            return;
        }
        getCurrentProject().setCurrentStageType(ProjectStageType.Awaiting_Cabinet_Submission);
        getCurrentProject().setDnpApprovedUser(loggedUser);
        getCurrentProject().setDnpApprovedAt(new Date());
        getCurrentProject().setDnpApproved(true);
        getProjectFacade().edit(currentProject);
        JsfUtil.addSuccessMessage("Marked as DNP Approved.");
    }

    public void markAsDnpRejected() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing selected");
            return;
        }
        getCurrentProject().setCurrentStageType(ProjectStageType.DNP_Rejected);
        getCurrentProject().setDnpRejectedUser(loggedUser);
        getCurrentProject().setDnpRejectedAt(new Date());
        getCurrentProject().setDnpRejected(true);
        getProjectFacade().edit(currentProject);
        JsfUtil.addSuccessMessage("Marked as Rejected by DNP.");
    }

    public void markAsSubmittedToCabinet() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing selected");
            return;
        }
        getCurrentProject().setCurrentStageType(ProjectStageType.Awaiting_Cabinet_Approval);
        getCurrentProject().setCabinetSubmissionUser(loggedUser);
        getCurrentProject().setCabinetSubmissionAt(new Date());
        getCurrentProject().setCabinetSubmitted(true);
        getProjectFacade().edit(currentProject);
        JsfUtil.addSuccessMessage("Marked as Submitted to Cabinet.");
    }

    public void markAsCabinetApproved() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing selected");
            return;
        }
        getCurrentProject().setCurrentStageType(ProjectStageType.Cabinet_Approved);
        getCurrentProject().setCabinetApprovedUser(loggedUser);
        getCurrentProject().setCabinetApprovedAt(new Date());
        getCurrentProject().setCabinetApproved(true);
        getProjectFacade().edit(currentProject);
        JsfUtil.addSuccessMessage("Marked as DNP Approved.");
    }

    /**
     *
     *
     *
     * Other Functions
     *
     *
     */
    public void uploadFiles() {
        if (getCurrentProject() == null) {
            facade.util.JsfUtil.addErrorMessage("No Project");
            return;
        }

        InputStream in;

        Upload u = new Upload();

        u.setProject(currentProject);
        u.setComments(comments);
        u.setCreatedAt(new Date());
        u.setUploadType(UploadType.Client_Upload_Prior_To_Proposal);
        currentProjectUploads = null;
        clientUploads = null;
        companyUploads = null;

        getUploadFacade().create(u);
        comments = "";

        StringWriter writer = new StringWriter();
        if (file != null) {
            try {
                in = getFile().getInputstream();
                File f = new File("P" + currentProject.getId() + "U" + u.getId());
                FileOutputStream out = new FileOutputStream(f);

                //            OutputStream out = new FileOutputStream(new File(fileName));
                int read = 0;
                byte[] bytes = new byte[1024];
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                in.close();
                out.flush();
                out.close();

                u.setRetireComments(f.getAbsolutePath());
                u.setFileName(file.getFileName());
                u.setFileType(file.getContentType());
                in = file.getInputstream();
                u.setBaImage(IOUtils.toByteArray(in));
                getUploadFacade().edit(u);
                JsfUtil.addSuccessMessage("File Uploaded");
            } catch (IOException io) {
                System.out.println("io = " + io);
                JsfUtil.addErrorMessage("Error in Uploading. " + io.getMessage());
            } catch (Exception e) {
                System.out.println("e = " + e);
                JsfUtil.addErrorMessage("Error in Uploading. " + e.getMessage());
            }

        }
    }

    public Project getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }

    public String prepareRegisterAsClient() {
        current = new WebUser();
        current.setWebUserRole(WebUserRole.Institution_User);
        currentProject = null;
        currentProjectUploads = null;
        companyUploads = null;
        clientUploads = null;
        currentUpload = null;

        return "/register";
    }

    public String updateWebUserAndToMarkLocation() {
        try {
            getFacade().edit(current);
        } catch (Exception e) {
            System.out.println("e = " + e);
            JsfUtil.addErrorMessage("Username already taken. Please enter a different username");
            return "";
        }
        Institution ins = current.getInstitution();
        if (ins == null) {
            ins = new Institution();
            ins.setName(current.getName());
            ins.setEmail(current.getEmail());
            ins.setPhone(current.getTelNo());
            ins.setAddress(current.getWebUserPerson().getAddress());
            ins.setInstitutionType(InstitutionType.Regional_Department_of_Health_Department);
            getInstitutionFacade().create(ins);
            current.setInstitution(ins);
        } else {
            ins.setName(current.getName());
            ins.setEmail(current.getEmail());
            ins.setPhone(current.getTelNo());
            ins.setAddress(current.getWebUserPerson().getAddress());
            ins.setInstitutionType(InstitutionType.Regional_Department_of_Health_Department);
            getInstitutionFacade().edit(ins);
        }
        getFacade().edit(current);
        JsfUtil.addSuccessMessage("Your Details Updated. Please add Your Location Details.");
        return "/location_of_a_client";
    }

    public String registerUser() {
        if (!current.getWebUserPassword().equals(password)) {
            JsfUtil.addErrorMessage("Passwords are not matching. Please retry.");
            return "";
        }
        current.setWebUserRole(WebUserRole.Institution_User);
        try {
            getFacade().create(current);
        } catch (Exception e) {
            System.out.println("e = " + e);
            JsfUtil.addErrorMessage("Username already taken. Please enter a different username");
            return "";
        }

        setLoggedUser(current);
        JsfUtil.addSuccessMessage("Your Details Added as an institution user. Please contact us for changes");
        return "/index";
    }

    public String logOut() {
        loggedUser = null;
        return "/index";
    }

    public String toLogin() {
        return "/login";
    }

    public String login() {
        if (userName == null || userName.trim().equals("")) {
            JsfUtil.addErrorMessage("Please enter a Username");
            return "";
        }
        if (password == null || password.trim().equals("")) {
            JsfUtil.addErrorMessage("Please enter the Password");
            return "";
        }
        if (!isFirstVisit()) {
            if (!checkLogin()) {
                JsfUtil.addErrorMessage("Username/Password Error. Please retry.");
                return "";
            }
        }
        JsfUtil.addSuccessMessage("Successfully Logged");
        return "index";
    }

    public String loginForMobile() {
        loginRequestResponse = "";
        if (userName == null || userName.trim().equals("")) {
            loginRequestResponse += "Wrong Isername. Please go back to settings and update.";
            return "/mobile/login_failure";
        }
        if (password == null || password.trim().equals("")) {
            loginRequestResponse += "Wrong Isername. Please go back to settings and update.";
            return "/mobile/login_failure";
        }
        if (!checkLogin()) {
            loginRequestResponse += "Wrong Isername. Please go back to settings and update.";
            return "/mobile/login_failure";
        }
        return "/mobile/index";
    }

    private boolean checkLogin() {
        System.out.println("Check Login");
        String temSQL;
        temSQL = "SELECT u FROM WebUser u WHERE lower(u.name)=:userName and u.retired =:ret";
        Map m = new HashMap();
        m.put("userName", userName.trim().toLowerCase());
        m.put("ret", false);
        loggedUser = getFacade().findFirstBySQL(temSQL, m);
        if (loggedUser == null) {
            return false;
        }
        if (password.equals(loggedUser.getWebUserPassword())) {
            System.out.println("Correct");
            return true;
        } else {
            System.out.println("wrong");
            loggedUser = null;
            return false;
        }

    }

    private boolean isFirstVisit() {
        System.out.println("is First Visit Check " + this);
        if (getFacade().count() <= 0) {
            JsfUtil.addSuccessMessage("First Visit");
            Institution ins = new Institution();
            ins.setName("Solar Bid, Inc");
            ins.setInstitutionType(InstitutionType.Ministry_of_Health);
            getInstitutionFacade().create(ins);
            WebUser wu = new WebUser();
            wu.getWebUserPerson().setName(userName);
            wu.setName(userName);
            wu.setWebUserPassword(password);
            wu.setInstitution(ins);
            wu.setWebUserRole(WebUserRole.System_Administrator);
            getFacade().create(wu);
            loggedUser = wu;
            return true;
        } else {
            System.out.println("NOT First Visit");
            return false;
        }

    }

    public String importProjectsFromExcel() {
        String strYear;
        String strProvince;
        String strFileNumber;
        String strDistrict;
        String strLocation;
        String strTile;
        String strDiscription;
        String strCost;
        String strFundSource;

        Double dblCost;
        Integer intYear;
        Institution insLocation;
        Area areaProvince;
        Area areaDistrict;
        Item itemFundSource;

        File inputWorkbook;
        Workbook w;
        Cell cell;
        InputStream in;

        int startRow = 1;

        JsfUtil.addSuccessMessage(file.getFileName());

        try {
            JsfUtil.addSuccessMessage(file.getFileName());
            in = file.getInputstream();
            File f;
            f = new File(Calendar.getInstance().getTimeInMillis() + file.getFileName());
            FileOutputStream out = new FileOutputStream(f);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();

            inputWorkbook = new File(f.getAbsolutePath());

            JsfUtil.addSuccessMessage("Excel File Opened");
            w = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = w.getSheet(0);

            for (int i = startRow; i < sheet.getRows(); i++) {

                Project np = new Project();
                np.setCreatedAt(new Date());
                np.setCreater(loggedUser);
                np.setCurrentStageType(ProjectStageType.Awaiting_PEC_Approval);

                Map m = new HashMap();

                //Year
                cell = sheet.getCell(0, i);
                strYear = cell.getContents();
                try {
                    intYear = Integer.parseInt(strYear);
                    np.setProjectYear(intYear);
                } catch (Exception e) {
                    System.out.println("e = " + i + " in " + e);
                }

                cell = sheet.getCell(1, i);
                strProvince = cell.getContents();

                cell = sheet.getCell(3, i);
                strDistrict = cell.getContents();

                if (strProvince.trim().equalsIgnoreCase("All Island")) {
                    np.setAllIsland(true);
                    np.setProvince(null);
                    np.setDistrict(null);
                } else {
                    areaProvince = areaController.getArea(strProvince, AreaType.Province, false, null);
                    areaDistrict = areaController.getArea(strDistrict, AreaType.District, true, areaProvince);
                    np.setProvince(areaProvince);
                    np.setDistrict(areaDistrict);
                }

                cell = sheet.getCell(2, i);
                strFileNumber = cell.getContents();
                np.setFileNumber(strFileNumber);

                cell = sheet.getCell(4, i);
                strLocation = cell.getContents();
                insLocation = institutionController.getInstitution(strLocation, InstitutionType.Other, true);
                np.setProjectLocation(insLocation);

                cell = sheet.getCell(5, i);
                strTile = cell.getContents();
                np.setProjectTitle(strTile);

                cell = sheet.getCell(6, i);
                strDiscription = cell.getContents();
                np.setProjectDescription(strDiscription);

                cell = sheet.getCell(7, i);
                strCost = cell.getContents();
                try {
                    dblCost = Double.parseDouble(strCost);
                    np.setProjectCost(dblCost);
                } catch (Exception e) {
                    System.out.println(i + ". e = " + e);
                }

                cell = sheet.getCell(8, i);
                strFundSource = cell.getContents();
                itemFundSource = itemController.getItem(strFundSource, ItemType.Source_of_Funds, true);
                np.setSourceOfFunds(itemFundSource);

                getProjectFacade().create(np);
                System.out.println("Added SUccessfully = " + i);

            }

            JsfUtil.addSuccessMessage("Succesful. All the data in Excel File Impoted to the database");
            return "";
        } catch (IOException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
            return "";
        } catch (BiffException e) {
            JsfUtil.addErrorMessage(e.getMessage());
            return "";
        }
    }

    public List<Upload> getUploads(Project p) {
        return getUploads(p, null);
    }

    public List<Upload> getUploads(Project p, UploadType type) {
        String j = "select u from Upload u "
                + " where u.project=:p ";
        Map m = new HashMap();
        m.put("p", currentProject);
        if (type != null) {
            j += " and u.uploadType=:t ";
            m.put("t", type);
        }
        return getUploadFacade().findBySQL(j, m);

    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public WebUserController() {
    }

    public WebUser getSelected() {
        return current;
    }

    private WebUserFacade getFacade() {
        return ejbFacade;
    }

    public String prepareList() {
        recreateModel();
        return "manage_users";
    }

    public String prepareView() {
        return "/webUser/View";
    }

    public String prepareCreate() {
        current = new WebUser();
        return "/webUser/Create";
    }

    public String create() {
        if (!password.equals(current.getWebUserPassword())) {
            JsfUtil.addErrorMessage("Passwords do NOT match");
            return "";
        }
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("WebUserCreated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return "";
        }
        return prepareCreate();
    }

    public String prepareEdit() {
        return "Edit";
    }

    public String prepareEditPassword() {
        return "Password";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("updated"));
            return "manage_users";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, e.getMessage());
            return null;
        }
    }

    public String updatePassword() {
        if (!password.equals(current.getWebUserPassword())) {
            JsfUtil.addErrorMessage("Passwords do NOT match");
            return "";
        }
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("WebUserUpdated"));
            return "manage_users";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        performDestroy();
        recreateModel();
        return "manage_users";
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("WebUserDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    public List<WebUser> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public WebUser getWebUser(java.lang.Long id) {
        return ejbFacade.find(id);
    }

    public InstitutionFacade getInstitutionFacade() {
        return institutionFacade;
    }

    public void setInstitutionFacade(InstitutionFacade institutionFacade) {
        this.institutionFacade = institutionFacade;
    }

    public WebUser getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(WebUser loggedUser) {
        this.loggedUser = loggedUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public facade.WebUserFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(facade.WebUserFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public WebUser getCurrent() {
        return current;
    }

    public void setCurrent(WebUser current) {
        this.current = current;
    }

    public CommonController getCommonController() {
        return commonController;
    }

    public MapModel getEmptyModel() {
        return emptyModel;
    }

    public void setEmptyModel(MapModel emptyModel) {
        this.emptyModel = emptyModel;
    }

    public ProjectFacade getProjectFacade() {
        return projectFacade;
    }

    public void setProjectFacade(ProjectFacade projectFacade) {
        this.projectFacade = projectFacade;
    }

    public UploadFacade getUploadFacade() {
        return uploadFacade;
    }

    public void setUploadFacade(UploadFacade uploadFacade) {
        this.uploadFacade = uploadFacade;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Upload getCurrentUpload() {
        return currentUpload;
    }

    public void setCurrentUpload(Upload currentUpload) {
        this.currentUpload = currentUpload;
    }

    public List<Upload> getCurrentProjectUploads() {
        if (currentProjectUploads == null) {
            currentProjectUploads = getUploads(currentProject);
        }
        return currentProjectUploads;
    }

    public void setCurrentProjectUploads(List<Upload> currentProjectUploads) {
        this.currentProjectUploads = currentProjectUploads;
    }

    public List<Project> getListOfProjects() {
        return listOfProjects;
    }

    public void setListOfProjects(List<Project> listOfProjects) {
        this.listOfProjects = listOfProjects;
    }

    public Date getFromDate() {
        if (fromDate == null) {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.MONTH, 0);
            c.set(Calendar.DATE, 1);
            fromDate = c.getTime();
        }
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        if (toDate == null) {
            toDate = new Date();
        }
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public List<Upload> getClientUploads() {
        if (clientUploads == null) {
            clientUploads = getUploads(currentProject, UploadType.Client_Upload_Prior_To_Proposal);
        }
        return clientUploads;
    }

    public void setClientUploads(List<Upload> clientUploads) {
        this.clientUploads = clientUploads;
    }

    public List<Upload> getCompanyUploads() {
        if (companyUploads == null) {
            companyUploads = getUploads(currentProject, UploadType.Company_Design_Upload);
        }
        return companyUploads;
    }

    public void setCompanyUploads(List<Upload> companyUploads) {
        this.companyUploads = companyUploads;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Area[] getSelectedProvinces() {
        return selectedProvinces;
    }

    public void setSelectedProvinces(Area[] selectedProvinces) {
        this.selectedProvinces = selectedProvinces;
    }

    public ProjectArea getSelectedProjectArea() {
        return selectedProjectArea;
    }

    public void setSelectedProjectArea(ProjectArea selectedProjectArea) {
        this.selectedProjectArea = selectedProjectArea;
    }

    public ProjectAreaFacade getProjectAreaFacade() {
        return projectAreaFacade;
    }

    public List<Area> getSelectedDistricts() {
        if (selectedDistricts == null) {
            selectedDistricts = new ArrayList<>();
        }
        return selectedDistricts;
    }

    public void setSelectedDistricts(List<Area> selectedDistricts) {
        this.selectedDistricts = selectedDistricts;
    }

    public List<Area> getSelectedDsAreas() {
        if (selectedDsAreas == null) {
            selectedDsAreas = new ArrayList<>();
        }
        return selectedDsAreas;
    }

    public void setSelectedDsAreas(List<Area> selectedDsAreas) {
        this.selectedDsAreas = selectedDsAreas;
    }

    public List<Area> getSelectedGnAreas() {
        return selectedGnAreas;
    }

    public void setSelectedGnAreas(List<Area> selectedGnAreas) {
        if (selectedGnAreas == null) {
            selectedGnAreas = new ArrayList<>();
        }
        this.selectedGnAreas = selectedGnAreas;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public Institution getLocation() {
        return location;
    }

    public void setLocation(Institution location) {
        this.location = location;
    }

    public Boolean getAllIslandProjects() {
        return allIslandProjects;
    }

    public void setAllIslandProjects(Boolean allIslandProjects) {
        this.allIslandProjects = allIslandProjects;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getLoginRequestResponse() {
        return loginRequestResponse;
    }

    public void setLoginRequestResponse(String loginRequestResponse) {
        this.loginRequestResponse = loginRequestResponse;
    }

    public String getLocale() {
        if (loggedUser != null) {
            locale = loggedUser.getDefLocale();
        } else {
            locale = "en";
        }
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public AreaController getAreaController() {
        return areaController;
    }

    public InstitutionController getInstitutionController() {
        return institutionController;
    }

    public ItemController getItemController() {
        return itemController;
    }

    @FacesConverter(forClass = WebUser.class)
    public static class WebUserControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            WebUserController controller = (WebUserController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "webUserController");
            return controller.getWebUser(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof WebUser) {
                WebUser o = (WebUser) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + WebUser.class.getName());
            }
        }

    }

}
