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
import ugt.entidades.Tbseccionsolicitantes;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbseccionsolicitantesFacade extends AbstractFacade<Tbseccionsolicitantes> implements TbseccionsolicitantesFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbseccionsolicitantesFacade() {
        super(Tbseccionsolicitantes.class);
    }

    @Override
    public List<Tbseccionsolicitantes> buscarxcedula(String cedula) {
        List<Tbseccionsolicitantes> result = new ArrayList<>();
        String consulta;
        try {
            consulta = "SELECT c FROM Tbseccionsolicitantes c WHERE c.cedulau.cedula = :ced";
            Query query = em.createQuery(consulta);
            query.setParameter("ced", cedula);
            result = query.getResultList();
        } catch (Exception e) {
        }
        return result;
    }
    
}
