/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sd
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId")
    , @NamedQuery(name = "User.findByPrefix", query = "SELECT u FROM User u WHERE u.prefix = :prefix")
    , @NamedQuery(name = "User.findByFname", query = "SELECT u FROM User u WHERE u.fname = :fname")
    , @NamedQuery(name = "User.findByLname", query = "SELECT u FROM User u WHERE u.lname = :lname")
    , @NamedQuery(name = "User.findByTel", query = "SELECT u FROM User u WHERE u.tel = :tel")
    , @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByPid", query = "SELECT u FROM User u WHERE u.pid = :pid")
    , @NamedQuery(name = "User.findByAddress", query = "SELECT u FROM User u WHERE u.address = :address")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
    , @NamedQuery(name = "User.findByImgSrc", query = "SELECT u FROM User u WHERE u.imgSrc = :imgSrc")
    , @NamedQuery(name = "User.findByActive", query = "SELECT u FROM User u WHERE u.active = :active")
    , @NamedQuery(name = "User.findByType", query = "SELECT u FROM User u WHERE u.type = :type")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "user_id")
    private String userId;
    @Size(max = 45)
    @Column(name = "prefix")
    private String prefix;
    @Size(max = 100)
    @Column(name = "fname")
    private String fname;
    @Size(max = 100)
    @Column(name = "lname")
    private String lname;
    @Size(max = 10)
    @Column(name = "tel")
    private String tel;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Size(max = 13)
    @Column(name = "pid")
    private String pid;
    @Size(max = 200)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 200)
    @Column(name = "email")
    private String email;
    @Size(max = 200)
    @Column(name = "img_src")
    private String imgSrc;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "type")
    private Integer type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crBy")
    private List<MediaRentalMas> mediaRentalMasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rentBy")
    private List<MediaRentalMas> mediaRentalMasList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crBy")
    private List<MediaReturnMas> mediaReturnMasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "returnBy")
    private List<MediaReturnMas> mediaReturnMasList1;

    public User() {
    }

    public User(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @XmlTransient
    public List<MediaRentalMas> getMediaRentalMasList() {
        return mediaRentalMasList;
    }

    public void setMediaRentalMasList(List<MediaRentalMas> mediaRentalMasList) {
        this.mediaRentalMasList = mediaRentalMasList;
    }

    @XmlTransient
    public List<MediaRentalMas> getMediaRentalMasList1() {
        return mediaRentalMasList1;
    }

    public void setMediaRentalMasList1(List<MediaRentalMas> mediaRentalMasList1) {
        this.mediaRentalMasList1 = mediaRentalMasList1;
    }

    @XmlTransient
    public List<MediaReturnMas> getMediaReturnMasList() {
        return mediaReturnMasList;
    }

    public void setMediaReturnMasList(List<MediaReturnMas> mediaReturnMasList) {
        this.mediaReturnMasList = mediaReturnMasList;
    }

    @XmlTransient
    public List<MediaReturnMas> getMediaReturnMasList1() {
        return mediaReturnMasList1;
    }

    public void setMediaReturnMasList1(List<MediaReturnMas> mediaReturnMasList1) {
        this.mediaReturnMasList1 = mediaReturnMasList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.User[ userId=" + userId + " ]";
    }
    
}
