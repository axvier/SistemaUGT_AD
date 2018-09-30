/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ugt.entidades.Tbdisponibilidadvc;

/**
 *
 * @author Usuario
 */
@Stateless
public class TbdisponibilidadvcFacade extends AbstractFacade<Tbdisponibilidadvc> implements TbdisponibilidadvcFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbdisponibilidadvcFacade() {
        super(Tbdisponibilidadvc.class);
    }
    
}
