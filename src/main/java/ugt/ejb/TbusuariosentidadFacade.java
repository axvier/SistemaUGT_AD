/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ugt.entidades.Tbusuariosentidad;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbusuariosentidadFacade extends AbstractFacade<Tbusuariosentidad> implements TbusuariosentidadFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbusuariosentidadFacade() {
        super(Tbusuariosentidad.class);
    }
    
    @Override
    public Tbusuariosentidad buscarusuarioentidad(String cedula) {
        List<Tbusuariosentidad> listauserentidad = null;
        Tbusuariosentidad result = new Tbusuariosentidad();
        String consulta;
        try {
            consulta = "SELECT t FROM Tbusuariosentidad t WHERE t.tbusuariosentidadPK.cedulau = :cedulau";
            Query query = em.createQuery(consulta);
            query.setParameter("cedulau", cedula);
            listauserentidad = query.getResultList();
            if(listauserentidad.size()>0){
                result = listauserentidad.get(0);
}
        } catch (Exception e) {
        }
        return result;
    }
    
}
