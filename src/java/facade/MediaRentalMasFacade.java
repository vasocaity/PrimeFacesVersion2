/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.MediaRentalMas;

/**
 *
 * @author sd
 */
@Stateless
public class MediaRentalMasFacade extends AbstractFacade<MediaRentalMas> {

    @PersistenceContext(unitName = "JSF_version2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MediaRentalMasFacade() {
        super(MediaRentalMas.class);
    }
    
}
