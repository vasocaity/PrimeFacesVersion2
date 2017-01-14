/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Media;

        /**
 *
 * @author sd
 */
@ManagedBean(name = "BDM02MEDCtrl")
@ViewScoped
public class BDM02MEDCtrl implements Serializable{

    /**
     * Creates a new instance of BDM01USRCtrl
     */
    @EJB
    private ejb.MediaEjb ejbLVl;
    private List<Media> itemLV1List;
    private Media selectedLV1One;
    public BDM02MEDCtrl() {
        
        
    }
    public void init(){
        this.onReadLV1();
    }
    public void prepareLv1Create()
    {
        this.selectedLV1One = new Media();
    }
    public void onReadLV1(){
        this.itemLV1List =this.ejbLVl.findAll();
    }
    public void onSaveLV1(){
        this.ejbLVl.edit(selectedLV1One);
                addMessage("Success", "Data saved");
    }
    public void onDelete()
    {
        this.ejbLVl.remove(selectedLV1One);
        this.onReadLV1();
                addMessage("Success", "Data saved");
    }
    public List<Media> getItemLV1List() {
        return itemLV1List;
    }

    public void setItemLV1List(List<Media> itemLV1List) {
        this.itemLV1List = itemLV1List;
    }

    public Media getSelectedLV1One() {
        return selectedLV1One;
    }

    public void setSelectedLV1One(Media selectedLV1One) {
        this.selectedLV1One = selectedLV1One;
    }
     public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }    
}
