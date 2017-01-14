/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sd
 */
@Entity
@Table(name = "media_rental_mas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MediaRentalMas.findAll", query = "SELECT m FROM MediaRentalMas m")
    , @NamedQuery(name = "MediaRentalMas.findByMdrMasId", query = "SELECT m FROM MediaRentalMas m WHERE m.mdrMasId = :mdrMasId")
    , @NamedQuery(name = "MediaRentalMas.findByTransDate", query = "SELECT m FROM MediaRentalMas m WHERE m.transDate = :transDate")})
public class MediaRentalMas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mdr_mas_id")
    private Integer mdrMasId;
    @Column(name = "trans_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mdrMasId")
    private List<MediaRentalDet> mediaRentalDetList;
    @JoinColumn(name = "cr_by", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User crBy;
    @JoinColumn(name = "rent_by", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User rentBy;

    public MediaRentalMas() {
    }

    public MediaRentalMas(Integer mdrMasId) {
        this.mdrMasId = mdrMasId;
    }

    public Integer getMdrMasId() {
        return mdrMasId;
    }

    public void setMdrMasId(Integer mdrMasId) {
        this.mdrMasId = mdrMasId;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    @XmlTransient
    public List<MediaRentalDet> getMediaRentalDetList() {
        return mediaRentalDetList;
    }

    public void setMediaRentalDetList(List<MediaRentalDet> mediaRentalDetList) {
        this.mediaRentalDetList = mediaRentalDetList;
    }

    public User getCrBy() {
        return crBy;
    }

    public void setCrBy(User crBy) {
        this.crBy = crBy;
    }

    public User getRentBy() {
        return rentBy;
    }

    public void setRentBy(User rentBy) {
        this.rentBy = rentBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mdrMasId != null ? mdrMasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaRentalMas)) {
            return false;
        }
        MediaRentalMas other = (MediaRentalMas) object;
        if ((this.mdrMasId == null && other.mdrMasId != null) || (this.mdrMasId != null && !this.mdrMasId.equals(other.mdrMasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.MediaRentalMas[ mdrMasId=" + mdrMasId + " ]";
    }
    
}
