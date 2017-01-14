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
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.MediaRentalMas;
import model.User;

/**
 *
 * @author sd
 */
@ManagedBean(name = "TSA01RENTCtrl")
@ViewScoped
public class TSA01RENTCtrl implements Serializable {

    /**
     * Creates a new instance of BDM01USRCtrl
     */
    @EJB
    private ejb.MediaRentalMasEjb ejbLVl;
    private List<MediaRentalMas> itemLV1List;
    private MediaRentalMas selectedLV1One;

    @EJB
    private ejb.UserEjb ejbUser;
    private List<User> itemRentByList;
    private List<User> itemCrByList;

    public TSA01RENTCtrl() {

    }

    public void init() {
        this.onReadLV1();
        this.itemRentByList = this.ejbUser.findAll();
        this.itemCrByList   = this.ejbUser.findByType(3);
        this.selectedLV1One = new MediaRentalMas();
    }

    public void prepareLv1Create() {
        this.selectedLV1One = new MediaRentalMas();
    }

    public void onReadLV1() {
        this.itemLV1List = this.ejbLVl.findAll();
    }

    public void onSaveLV1() {
        this.ejbLVl.edit(selectedLV1One);
        addMessage("Success", "Data saved");
    }

    public void onDelete() {
        this.ejbLVl.remove(selectedLV1One);
        this.onReadLV1();
        addMessage("Success", "Data saved");
    }

    public List<MediaRentalMas> getItemLV1List() {
        return itemLV1List;
    }

    public void setItemLV1List(List<MediaRentalMas> itemLV1List) {
        this.itemLV1List = itemLV1List;
    }

    public MediaRentalMas getSelectedLV1One() {
        return selectedLV1One;
    }

    public void setSelectedLV1One(MediaRentalMas selectedLV1One) {
        this.selectedLV1One = selectedLV1One;
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<User> getItemRentByList() {
        return itemRentByList;
    }

    public void setItemRentByList(List<User> itemRentByList) {
        this.itemRentByList = itemRentByList;
    }

    public List<User> getItemCrByList() {
        return itemCrByList;
    }

    public void setItemCrByList(List<User> itemCrByList) {
        this.itemCrByList = itemCrByList;
    }

}
