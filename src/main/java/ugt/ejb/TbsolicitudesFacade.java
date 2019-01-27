/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import ugt.entidades.Tbsolicitudes;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbsolicitudesFacade extends AbstractFacade<Tbsolicitudes> implements TbsolicitudesFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbsolicitudesFacade() {
        super(Tbsolicitudes.class);
    }

    @Override
    public List<Tbsolicitudes> buscarallxcedula(String cedula) {
        List<Tbsolicitudes> result = null;
        String consulta;
        try {
            consulta = "SELECT t.solicitud FROM Tbseccionsolicitantes t WHERE t.cedulau.cedula = :numero and t.solicitud.estado <> :eliminado order by t.solicitud.numero asc";
            Query con = em.createQuery(consulta);
            con.setParameter("numero", cedula);
            con.setParameter("eliminado", "eliminada");
            result = con.getResultList();
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public List<Tbsolicitudes> filtrarXestado(String estado) {
        List<Tbsolicitudes> result = null;
        String consulta;
        try {
            consulta = "SELECT t FROM Tbsolicitudes t WHERE t.estado = :estado order by t.numero asc";
            Query con = em.createQuery(consulta);
            con.setParameter("estado", estado);
            result = con.getResultList();
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public List<Tbsolicitudes> filtrarXNOestado(String estado) {
        List<Tbsolicitudes> result = null;
        String consulta;
        try {
            consulta = "SELECT t FROM Tbsolicitudes t WHERE t.estado <> :estado order by t.numero asc";
            Query con = em.createQuery(consulta);
            con.setParameter("estado", estado);
            result = con.getResultList();
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public List<Tbsolicitudes> findAllEnviadoAsignada() {
        List<Tbsolicitudes> result = null;
        String consulta;
        try {
            consulta = "SELECT t FROM Tbsolicitudes t WHERE t.estado IN ('enviado','asignada') order by t.numero asc";
            Query con = em.createQuery(consulta);

            result = con.getResultList();
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public long countEstadosFechas(String estados, Date fechaInicio, Date fechaFin) {
        long result = 0;
        String consulta;
        try {
            consulta = "SELECT count(t.numero) FROM Tbsolicitudes t WHERE t.estado = :estado AND t.fecha BETWEEN :startDate AND :endDate";
            Query con = em.createQuery(consulta);
            con.setParameter("estado", estados);
            con.setParameter("startDate", fechaInicio, TemporalType.DATE);
            con.setParameter("endDate", fechaFin, TemporalType.DATE);
            result = (long) con.getSingleResult();
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public long countEstados(String estado) {
        long result = 0;
        String consulta;
        try {
            consulta = "SELECT count(t.numero) FROM Tbsolicitudes t WHERE t.estado = :estado";
            Query con = em.createQuery(consulta);
            con.setParameter("estado", estado);
            result = (long) con.getSingleResult();
        } catch (Exception e) {
        }
        return result;
    }

}
