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
import ugt.entidades.Tbconductores;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbconductoresFacade extends AbstractFacade<Tbconductores> implements TbconductoresFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbconductoresFacade() {
        super(Tbconductores.class);
    }

    @Override
    public List<Tbconductores> disponibles() {
        List<Tbconductores> listaconductor = null;
        String consulta;
        try {
            consulta = "SELECT c FROM Tbconductores c WHERE c.estado <> ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, "Bloqueado");
            listaconductor = query.getResultList();
        } catch (Exception e) {
        }
        return listaconductor;
    }

    @Override
    public List<Tbconductores> bloqueados() {
        List<Tbconductores> listaconductor = null;
        String consulta;
        try {
            consulta = "SELECT c FROM Tbconductores c WHERE c.estado=?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, "Bloqueado");
            listaconductor = query.getResultList();
        } catch (Exception e) {
        }
        return listaconductor;
    }

    @Override
    public int modconductor(Tbconductores tbconductores, String cedula) {
//        Tbvehiculos vehiculo = new Tbvehiculos();
        int result = 0;
//        List<Tbvehiculos> listavehiculo = null;
        String consulta;
        try {
            consulta = "UPDATE Tbconductores SET estado = :estd WHERE cedula = :ced";
            Query con = em.createQuery(consulta);
            con.setParameter("estd", tbconductores.getEstado());
            con.setParameter("ced", cedula);
            result = con.executeUpdate();
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public List<Tbconductores> findAllOrden(String forma, String campo) {
        List<Tbconductores> listaconductor = null;
        String consulta;
        try {
            consulta = "SELECT c FROM Tbconductores c WHERE c.estado <> :jubilado ORDER BY c." + campo + " " + forma;
            Query query = em.createQuery(consulta);
            query.setParameter("jubilado", "Jubilado");
            listaconductor = query.getResultList();
        } catch (Exception e) {
        }
        return listaconductor;
    }

    @Override
    public int countEstado(String estado) {
        int result = 0;
        String consulta;
        try {
            consulta = "SELECT COUNT(t.cedula) FROM Tbconductores t WHERE t.estado = :estado";
            Query query = em.createQuery(consulta);
            query.setParameter("estado", estado);
            result =(int) query.getSingleResult();
        } catch (Exception e) {
        }
        return result;
    }

}
