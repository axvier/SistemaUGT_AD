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
import ugt.entidades.Tbvehiculos;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbvehiculosFacade extends AbstractFacade<Tbvehiculos> implements TbvehiculosFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbvehiculosFacade() {
        super(Tbvehiculos.class);
    }

    @Override
    public int modconductor(Tbvehiculos tbvehiculo, String placa) {
        int result = 0;
//        List<Tbvehiculos> listavehiculo = null;
        String consulta;
        try {
            consulta = "UPDATE Tbvehiculos SET estado = :estd WHERE placa = :placav";
            Query con = em.createQuery(consulta);
            con.setParameter("estd", tbvehiculo.getEstado());
            con.setParameter("placav", placa);
            result = con.executeUpdate();
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public List<Tbvehiculos> disponibles() {
        List<Tbvehiculos> listavehiculos = null;
        String consulta;
        try {
            consulta = "SELECT c FROM Tbvehiculos c WHERE c.estado <> ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, "Bloqueado");
            listavehiculos = query.getResultList();
        } catch (Exception e) {
        }
        return listavehiculos;
    }

    @Override
    public List<Tbvehiculos> filtrarXidgrupo(Integer idgrupo) {
        List<Tbvehiculos> listavehiculos = null;
        String consulta;
        try {
            consulta = "SELECT v FROM Tbvehiculos v WHERE v.idgrupo.idgrupo = :idgrupo";
            Query query = em.createQuery(consulta);
            query.setParameter("idgrupo", idgrupo);
            listavehiculos = query.getResultList();
        } catch (Exception e) {
        }
        return listavehiculos;
    }

    @Override
    public long countEstado(String estado) {
        long result = 0;
        String consulta;
        try {
            consulta = "SELECT COUNT(v.placa) FROM Tbvehiculos v WHERE v.estado = :estado";
            Query query = em.createQuery(consulta);
            query.setParameter("estado", estado);
            result =(long) query.getSingleResult();
        } catch (Exception e) {
        }
        return result;
    }

}
