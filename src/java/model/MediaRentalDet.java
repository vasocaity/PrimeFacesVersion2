/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sd
 */
@Entity
@Table(name = "media_rental_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MediaRentalDet.findAll", query = "SELECT m FROM MediaRentalDet m")
    , @NamedQuery(name = "MediaRentalDet.findByMdrDetId", query = "SELECT m FROM MediaRentalDet m WHERE m.mdrDetId = :mdrDetId")
    , @NamedQuery(name = "MediaRentalDet.findByFineDay", query = "SELECT m FROM MediaRentalDet m WHERE m.fineDay = :fineDay")
    , @NamedQuery(name = "MediaRentalDet.findByFineRate", query = "SELECT m FROM MediaRentalDet m WHERE m.fineRate = :fineRate")
    , @NamedQuery(name = "MediaRentalDet.findByFine", query = "SELECT m FROM MediaRentalDet m WHERE m.fine = :fine")})
public class MediaRentalDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mdr_det_id")
    private Integer mdrDetId;
    @Column(name = "fine_day")
    private Integer fineDay;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fine_rate")
    private BigDecimal fineRate;
    @Column(name = "fine")
    private BigDecimal fine;
    @JoinColumn(name = "media_id", referencedColumnName = "media_id")
    @ManyToOne(optional = false)
    private Media mediaId;
    @JoinColumn(name = "mdr_mas_id", referencedColumnName = "mdr_mas_id")
    @ManyToOne(optional = false)
    private MediaRentalMas mdrMasId;
    @JoinColumn(name = "mre_mas_id", referencedColumnName = "mre_mas_id")
    @ManyToOne
    private MediaReturnMas mreMasId;

    public MediaRentalDet() {
    }

    public MediaRentalDet(Integer mdrDetId) {
        this.mdrDetId = mdrDetId;
    }

    public Integer getMdrDetId() {
        return mdrDetId;
    }

    public void setMdrDetId(Integer mdrDetId) {
        this.mdrDetId = mdrDetId;
    }

    public Integer getFineDay() {
        return fineDay;
    }

    public void setFineDay(Integer fineDay) {
        this.fineDay = fineDay;
    }

    public BigDecimal getFineRate() {
        return fineRate;
    }

    public void setFineRate(BigDecimal fineRate) {
        this.fineRate = fineRate;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    public Media getMediaId() {
        return mediaId;
    }

    public void setMediaId(Media mediaId) {
        this.mediaId = mediaId;
    }

    public MediaRentalMas getMdrMasId() {
        return mdrMasId;
    }

    public void setMdrMasId(MediaRentalMas mdrMasId) {
        this.mdrMasId = mdrMasId;
    }

    public MediaReturnMas getMreMasId() {
        return mreMasId;
    }

    public void setMreMasId(MediaReturnMas mreMasId) {
        this.mreMasId = mreMasId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mdrDetId != null ? mdrDetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaRentalDet)) {
            return false;
        }
        MediaRentalDet other = (MediaRentalDet) object;
        if ((this.mdrDetId == null && other.mdrDetId != null) || (this.mdrDetId != null && !this.mdrDetId.equals(other.mdrDetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.MediaRentalDet[ mdrDetId=" + mdrDetId + " ]";
    }
    
}
