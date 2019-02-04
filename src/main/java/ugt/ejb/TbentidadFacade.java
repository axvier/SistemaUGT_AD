/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ugt.entidades.Tbentidad;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbentidadFacade extends AbstractFacade<Tbentidad> implements TbentidadFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbentidadFacade() {
        super(Tbentidad.class);
    }

    @Override
    public List<Tbentidad> findAll(String campo, String tipoOrden) {
        List<Tbentidad> result = new ArrayList<>();
        try {
            String consulta = "SELECT t FROM Tbentidad t ORDER BY t." + campo + " " + tipoOrden;
            Query con = em.createNamedQuery(consulta);
            result = con.getResultList();
        } catch (Exception e) {
        }
        return result;
    }

}
