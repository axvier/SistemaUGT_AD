/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ugt.entidades.Tbvehiculosdependencias;

/**
 *
 * @author Usuario
 */
@Stateless
public class TbvehiculosdependenciasFacade extends AbstractFacade<Tbvehiculosdependencias> implements TbvehiculosdependenciasFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbvehiculosdependenciasFacade() {
        super(Tbvehiculosdependencias.class);
    }
    
}
