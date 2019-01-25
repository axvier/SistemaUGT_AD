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
import ugt.entidades.Tbregistros;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbregistrosFacade extends AbstractFacade<Tbregistros> implements TbregistrosFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbregistrosFacade() {
        super(Tbregistros.class);
    }

    @Override
    public List<Tbregistros> findById_TablaDescFecha(String idtabla, String tabla) {
        List<Tbregistros> result = new ArrayList<>();
        try {
            String consulta = "SELECT t FROM Tbregistros t WHERE t.idtabla = :idtabla AND t.tabla = :tabla ORDER BY t.fecha DESC";
            Query query = em.createQuery(consulta);
            query.setParameter("idtabla", idtabla);
            query.setParameter("tabla", tabla);
            result = query.getResultList();
        } catch (Exception e) {
        }
        return result;
    }
    
}
