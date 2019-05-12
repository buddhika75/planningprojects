package bean;

import entity.WebUser;

import entity.Bid;
import entity.Institution;
import entity.InstitutionType;
import entity.Project;
import entity.ProjectStageType;
import entity.Upload;
import entity.UploadType;
import entity.WebUserRole;
import facade.BidFacade;
import facade.InstitutionFacade;
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
    private BidFacade bidFacade;
    /*
    Controllers
     */
    @Inject
    private CommonController commonController;

    /*
    Variables
     */
    private List<WebUser> items = null;
    private List<Upload> currentProjectUploads;
    private List<Upload> clientUploads;
    private List<Upload> companyUploads;
    private List<Project> listOfProjects;
    private List<Bid> currentProjectBids;

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

    @PostConstruct
    public void init() {
        emptyModel = new DefaultMapModel();
    }
    
    public String listProjectsToSubmitBids() {
        listProjectsToSubmitBids(getLoggedUser().getInstitution());
        return "/list_for_providers";
    }

    public void listProjectsToSubmitBids(Institution provider) {
        List<Project> ps = listProjects(ProjectStageType.Awaiting_Biding);
        listOfProjects = new ArrayList<>();
        for(Project p : ps){
            if(!hasBidded(p, provider)){
                listOfProjects.add(p);
            }
        }
    }
    
    public boolean hasBidded(Project p, Institution i){
        String j = "select b from Bid b "
                + " where b.bidder=:i "
                + " and b.project=:p";
        Map m = new HashMap();
        m.put("p", p);
        m.put("i", i);
        Bid b = getBidFacade().findFirstBySQL(j, m);
        if(b==null){
            return false;
        }
        return true;
    }

    public String listProjectsToSubmitProposals() {
        listOfProjects = listProjects(ProjectStageType.Awaiting_Proposal);
        return "/client_requests";
    }

    public String listProjectsAwaitingCustomerApproval() {
        listOfProjects = listProjects(ProjectStageType.Awaiting_Customer_Approval);
        return "/client_requests";
    }

    public String listProjectsAwaitingBidding() {
        listOfProjects = listProjects(ProjectStageType.Awaiting_Biding);
        return "/client_requests";
    }

    public String listProjectsAwaitingBidSelection() {
        listOfProjects = listProjects(ProjectStageType.Awaiting_Bid_Selection);
        return "/client_requests";
    }

    public String listProjectsBidSelected() {
        listOfProjects = listProjects(ProjectStageType.Bidder_Selected);
        return "/client_requests";
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

    public String viewProjectToSubmitProposalsByCompany() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Please select a project");
            return "";
        }
        current = currentProject.getCreater();
        currentProjectUploads = null;
        companyUploads = null;
        clientUploads = null;
        currentUpload = null;
        currentProjectBids=null;
        markLocationOnMap();
        return "/project_company_view_after_submission";
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
        currentProjectBids=null;
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
    
    
    public String toSubmitClientRequest(){
        return "/finalize_client_request";
    }

    public String submitClientRequest() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Please refresh and login to system to submit.");
            return "";
        }
        currentProject.setRequestSubmittedAt(new Date());
        currentProject.setCurrentStageType(ProjectStageType.Awaiting_Proposal);
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
        currentProject.setClient(current.getInstitution());
        currentProject.setCreater(current);
        currentProject.setCreatedAt(new Date());
        currentProject.setCurrentStageType(ProjectStageType.Initial_Request);
        getProjectFacade().create(currentProject);
        return "add_photos_to_project_by_client";
    }

    public void updateProject() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to update");
            return;
        }
        getProjectFacade().edit(currentProject);
        JsfUtil.addSuccessMessage("Updated");
    }

    public void finalizeProposal() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to finalize");
            return;
        }
        getCurrentProject().setCurrentStageType(ProjectStageType.Awaiting_Customer_Approval);
        getCurrentProject().setProposalSubmittedAt(new Date());
        getCurrentProject().setProposalSubmittedBy(loggedUser);
        getProjectFacade().edit(currentProject);
        JsfUtil.addSuccessMessage("Updated");
    }

    public void acceptProposal() {
        if (currentProject == null) {
            JsfUtil.addErrorMessage("Nothing to accept");
            return;
        }
        getCurrentProject().setCurrentStageType(ProjectStageType.Awaiting_Biding);
        getCurrentProject().setProposalAcceptedAt(new Date());

        getProjectFacade().edit(currentProject);
        JsfUtil.addSuccessMessage("Updated");
    }

    public void uploadByCompanyAsProposal() {
        if (getCurrentProject() == null) {
            facade.util.JsfUtil.addErrorMessage("No Project");
            return;
        }

        InputStream in;

        Upload u = new Upload();

        u.setProject(currentProject);
        u.setComments(comments);
        u.setCreatedAt(new Date());
        u.setUploadType(UploadType.Company_Design_Upload);
        currentProjectUploads = null;
        companyUploads = null;
        clientUploads = null;
        currentProjectBids=null;
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

    public void uploadByCustomerBeforeTechnicalProposal() {
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
        currentProjectBids=null;
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
        currentProjectBids=null;
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

    
    public List<Bid> getBids(Project p) {
        return getBids(p, null);
    }
    

    public List<Bid> getBids(Project p, Institution provider) {
        String j = "select b from Bid b "
                + " where b.project=:p ";
        Map m = new HashMap();
        m.put("p", currentProject);
        if (provider != null) {
            j += " and u.bidder=:b ";
            m.put("b", provider);
        }
        return getBidFacade().findBySQL(j, m);

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
            return "system_management";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("WebUserUpdated"));
            return "manage_users";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
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

    public List<Bid> getCurrentProjectBids() {
        if (currentProjectBids == null) {
            currentProjectBids = getBids(currentProject);
        }
        return currentProjectBids;
    }

    public void setCurrentProjectBids(List<Bid> currentProjectBids) {
        this.currentProjectBids = currentProjectBids;
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

    public BidFacade getBidFacade() {
        return bidFacade;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
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
