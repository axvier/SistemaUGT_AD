/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ugt.entidades.Tbtipoentidad;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbtipoentidadFacade extends AbstractFacade<Tbtipoentidad> implements TbtipoentidadFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbtipoentidadFacade() {
        super(Tbtipoentidad.class);
    }
    
}
