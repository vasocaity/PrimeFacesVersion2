/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
@Table(name = "media_return_mas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MediaReturnMas.findAll", query = "SELECT m FROM MediaReturnMas m")
    , @NamedQuery(name = "MediaReturnMas.findByMreMasId", query = "SELECT m FROM MediaReturnMas m WHERE m.mreMasId = :mreMasId")
    , @NamedQuery(name = "MediaReturnMas.findByTransDate", query = "SELECT m FROM MediaReturnMas m WHERE m.transDate = :transDate")
    , @NamedQuery(name = "MediaReturnMas.findByFine", query = "SELECT m FROM MediaReturnMas m WHERE m.fine = :fine")})
public class MediaReturnMas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mre_mas_id")
    private Integer mreMasId;
    @Column(name = "trans_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fine")
    private BigDecimal fine;
    @OneToMany(mappedBy = "mreMasId")
    private List<MediaRentalDet> mediaRentalDetList;
    @JoinColumn(name = "cr_by", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User crBy;
    @JoinColumn(name = "return_by", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User returnBy;

    public MediaReturnMas() {
    }

    public MediaReturnMas(Integer mreMasId) {
        this.mreMasId = mreMasId;
    }

    public Integer getMreMasId() {
        return mreMasId;
    }

    public void setMreMasId(Integer mreMasId) {
        this.mreMasId = mreMasId;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
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

    public User getReturnBy() {
        return returnBy;
    }

    public void setReturnBy(User returnBy) {
        this.returnBy = returnBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mreMasId != null ? mreMasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaReturnMas)) {
            return false;
        }
        MediaReturnMas other = (MediaReturnMas) object;
        if ((this.mreMasId == null && other.mreMasId != null) || (this.mreMasId != null && !this.mreMasId.equals(other.mreMasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.MediaReturnMas[ mreMasId=" + mreMasId + " ]";
    }
    
}
