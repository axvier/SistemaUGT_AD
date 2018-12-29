/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public List<Tbusuariosentidad> buscarusuarioentidad(String cedula) {
        List<Tbusuariosentidad> listauserentidad = null;
        Tbusuariosentidad result = new Tbusuariosentidad();
        String consulta;
        try {
            consulta = "SELECT t FROM Tbusuariosentidad t WHERE t.tbusuariosentidadPK.cedulau = :cedulau AND t.fechafin IS NULL";
            Query query = em.createQuery(consulta);
            query.setParameter("cedulau", cedula);
            listauserentidad = query.getResultList();
        } catch (Exception e) {
        }
        return listauserentidad;
    }

    @Override
    public List<Tbusuariosentidad> totalusuarioentidad(String cedula) {
        List<Tbusuariosentidad> listauserentidad = null;
        Tbusuariosentidad result = new Tbusuariosentidad();
        String consulta;
        try {
            consulta = "SELECT t FROM Tbusuariosentidad t WHERE t.tbusuariosentidadPK.cedulau = :cedulau";
            Query query = em.createQuery(consulta);
            query.setParameter("cedulau", cedula);
            listauserentidad = query.getResultList();
        } catch (Exception e) {
        }
        return listauserentidad;
    }

    @Override
    public Tbusuariosentidad bentidadusuario(String cedula, String idrol) {
        Tbusuariosentidad result = new Tbusuariosentidad();
        String consulta;
        try {
            consulta = "SELECT t FROM Tbusuariosentidad t WHERE t.tbusuariosentidadPK.cedulau = :cedulau AND t.tbusuariosentidadPK.idrol = :idrol";
            Query query = em.createQuery(consulta);
            query.setParameter("cedulau", cedula);
            query.setParameter("idrol", Integer.parseInt(idrol));
            List<Tbusuariosentidad> listauserentidad = query.getResultList();
            if (listauserentidad.size() > 0 && listauserentidad.size() < 2) {
                result = listauserentidad.get(0);
            }
        } catch (NumberFormatException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "problemas en ejecutar hql usuario entidad rol con cedula y rol ", e.getClass().getName() + "****" + e.getMessage());
            System.err.println("ERROR: " + e.getClass().getName() + "***" + e.getMessage());
        }
        return result;
    }

}
