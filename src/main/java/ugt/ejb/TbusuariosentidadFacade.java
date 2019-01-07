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
import ugt.entidades.Tbrolesopciones;
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

    @Override
    public Tbusuariosentidad bentidadusuarioopc(String cedula, int idopcion) {
        Tbusuariosentidad result = new Tbusuariosentidad();
        String consulta;
        try {
            consulta = "SELECT t FROM Tbrolesopciones t WHERE t.idopcion.idopcion = :idopcion";
            Query query = em.createQuery(consulta);
            query.setParameter("idopcion", idopcion);
            List<Tbrolesopciones> listarolesopc = query.getResultList();
            if (listarolesopc.size() > 0 && listarolesopc.size() < 2) {
                Tbrolesopciones aux = listarolesopc.get(0);
//                em.flush();
                consulta = "SELECT t FROM Tbusuariosentidad t WHERE t.tbusuariosentidadPK.idrol = :idrol AND t.tbusuariosentidadPK.cedulau = :cedulau";
                query = em.createQuery(consulta);
                query.setParameter("idrol", aux.getIdrol().getIdrol());
                query.setParameter("cedulau", cedula);
                List<Tbusuariosentidad> listaAUX = query.getResultList();
                if(listaAUX.size() >0 && listaAUX.size()<2){
                    result = listaAUX.get(0);
                }
            }
        } catch (NumberFormatException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "problemas en ejecutar hql usuario entidad rol con cedula y char rol ", e.getClass().getName() + "****" + e.getMessage());
            System.err.println("ERROR: " + e.getClass().getName() + "***" + e.getMessage());
        }
        return result;
    }

}
