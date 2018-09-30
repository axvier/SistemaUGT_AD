/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ugt.entidades.Tbordenesmovilizaciones;

/**
 *
 * @author Usuario
 */
@Stateless
public class TbordenesmovilizacionesFacade extends AbstractFacade<Tbordenesmovilizaciones> implements TbordenesmovilizacionesFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbordenesmovilizacionesFacade() {
        super(Tbordenesmovilizaciones.class);
    }
    
}
