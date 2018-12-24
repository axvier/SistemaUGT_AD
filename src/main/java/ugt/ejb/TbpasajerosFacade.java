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
import ugt.entidades.Tbpasajeros;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbpasajerosFacade extends AbstractFacade<Tbpasajeros> implements TbpasajerosFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbpasajerosFacade() {
        super(Tbpasajeros.class);
    }

    @Override
    public List<Tbpasajeros> buscarXIDviaje(Integer id) {
        List<Tbpasajeros> lista = new ArrayList<>();
        String consulta;
        try {
            consulta = "SELECT t FROM Tbpasajeros t WHERE t.idviaje.idviaje = :numero";
            Query con = em.createQuery(consulta);
            con.setParameter("numero", id);
            lista = con.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }
    
}
