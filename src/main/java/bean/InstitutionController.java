package bean;

import entity.Institution;

import entity.InstitutionType;
import facade.InstitutionFacade;
import facade.util.JsfUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("institutionController")
@SessionScoped
public class InstitutionController implements Serializable {

    /*
    EJBs
     */
    @EJB
    private facade.InstitutionFacade ejbFacade;

    /*
    Class Variables
     */
    private Institution current;
    private List<Institution> items = null;
    private List<Institution> providers = null;
    private List<Institution> clients = null;

    public InstitutionController() {
    }

    public List<Institution> getInstitutions(InstitutionType type) {
        String j = "Select i from Institution i where "
                + " i.retired=false "
                + " and i.institutionType=:t "
                + " order by i.name";
        Map m = new HashMap();
        m.put("t", type);
        return getFacade().findBySQL(j, m);
    }

    private InstitutionFacade getFacade() {
        return ejbFacade;
    }

    public String prepareListOfProviders() {
        recreateModel();
        return "/institution/Manage";
    }

    public String prepareListOfClients() {
        recreateModel();
        return "/client/Manage";
    }

    public String prepareView() {
        return "View";
    }

    public String prepareCreate() {
        current = new Institution();
        return "Create";
    }

    public String createProvider() {
        try {
            current.setInstitutionType(InstitutionType.Provider);
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("InstitutionCreated"));
            return prepareListOfProviders();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String createClient() {
        try {
            current.setInstitutionType(InstitutionType.Client);
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("InstitutionCreated"));
            return prepareListOfClients();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        return "Edit";
    }

    public String prepareEditCompany() {
        String j = "Select i from Institution i where "
                + " i.retired=false "
                + " and i.institutionType=:t "
                + " order by i.name";
        Map m = new HashMap();
        m.put("t", InstitutionType.Company);
        current = getFacade().findFirstBySQL(j, m);
        if (current == null) {
            current = new Institution();
            current.setInstitutionType(InstitutionType.Company);
            current.setName("");
            getFacade().create(current);
        }
        return "/institution/Company";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("InstitutionUpdated"));
            return "Manage";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }
    
    
    

    public String updateCompany() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("InstitutionUpdated"));
            return "/system_management";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        performDestroy();
        recreateModel();
        return "Manage";
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("InstitutionDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    public List<Institution> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
        providers = null;
        clients = null;
    }

    public List<Institution> getItemsAvailableSelectMany() {
        return ejbFacade.findAll();
    }

    public List<Institution> getItemsAvailableSelectOne() {
        return ejbFacade.findAll();
    }

    public Institution getInstitution(java.lang.Long id) {
        return ejbFacade.find(id);
    }

    public Institution getCurrent() {
        return current;
    }

    public void setCurrent(Institution current) {
        this.current = current;
    }

    public List<Institution> getProviders() {
        if (providers == null) {
            providers = getInstitutions(InstitutionType.Provider);
        }
        return providers;
    }

    public void setProviders(List<Institution> providers) {
        this.providers = providers;
    }

    public List<Institution> getClients() {
        if (clients == null) {
            clients = getInstitutions(InstitutionType.Client);
        }
        return clients;
    }

    public void setClients(List<Institution> clients) {
        this.clients = clients;
    }

    @FacesConverter(forClass = Institution.class)
    public static class InstitutionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InstitutionController controller = (InstitutionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "institutionController");
            return controller.getInstitution(getKey(value));
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
            if (object instanceof Institution) {
                Institution o = (Institution) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Institution.class.getName());
            }
        }

    }

}
