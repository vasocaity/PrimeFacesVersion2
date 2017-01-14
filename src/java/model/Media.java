/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "media")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Media.findAll", query = "SELECT m FROM Media m")
    , @NamedQuery(name = "Media.findByMediaId", query = "SELECT m FROM Media m WHERE m.mediaId = :mediaId")
    , @NamedQuery(name = "Media.findByName", query = "SELECT m FROM Media m WHERE m.name = :name")
    , @NamedQuery(name = "Media.findByIsbn", query = "SELECT m FROM Media m WHERE m.isbn = :isbn")
    , @NamedQuery(name = "Media.findByFine", query = "SELECT m FROM Media m WHERE m.fine = :fine")
    , @NamedQuery(name = "Media.findByFineDay", query = "SELECT m FROM Media m WHERE m.fineDay = :fineDay")
    , @NamedQuery(name = "Media.findByAuthor", query = "SELECT m FROM Media m WHERE m.author = :author")
    , @NamedQuery(name = "Media.findByActive", query = "SELECT m FROM Media m WHERE m.active = :active")
    , @NamedQuery(name = "Media.findByAvaliable", query = "SELECT m FROM Media m WHERE m.avaliable = :avaliable")})
public class Media implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "media_id")
    private String mediaId;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "isbn")
    private String isbn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fine")
    private BigDecimal fine;
    @Column(name = "fine_day")
    private Integer fineDay;
    @Size(max = 200)
    @Column(name = "author")
    private String author;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "avaliable")
    private Boolean avaliable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mediaId")
    private List<MediaRentalDet> mediaRentalDetList;

    public Media() {
    }

    public Media(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    public Integer getFineDay() {
        return fineDay;
    }

    public void setFineDay(Integer fineDay) {
        this.fineDay = fineDay;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(Boolean avaliable) {
        this.avaliable = avaliable;
    }

    @XmlTransient
    public List<MediaRentalDet> getMediaRentalDetList() {
        return mediaRentalDetList;
    }

    public void setMediaRentalDetList(List<MediaRentalDet> mediaRentalDetList) {
        this.mediaRentalDetList = mediaRentalDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mediaId != null ? mediaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Media)) {
            return false;
        }
        Media other = (Media) object;
        if ((this.mediaId == null && other.mediaId != null) || (this.mediaId != null && !this.mediaId.equals(other.mediaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Media[ mediaId=" + mediaId + " ]";
    }
    
}
