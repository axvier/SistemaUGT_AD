/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import ugt.entidades.Tbvehiculosdependencias;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbvehiculosdependenciasFacade extends AbstractFacade<Tbvehiculosdependencias> implements TbvehiculosdependenciasFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbvehiculosdependenciasFacade() {
        super(Tbvehiculosdependencias.class);
    }

    @Override
    public Tbvehiculosdependencias findByPlaca(String placa) {
        Tbvehiculosdependencias result = new Tbvehiculosdependencias();
        List<Tbvehiculosdependencias> lista = new ArrayList<>();
        try {
            String consulta = "SELECT t FROM Tbvehiculosdependencias t WHERE t.tbvehiculosdependenciasPK.matricula = :matricula AND t.fechafin is null";
            Query con = em.createQuery(consulta);
            con.setParameter("matricula", placa);
            lista = con.getResultList();
            if (lista.size() > 0 && lista.size() < 2) {
                result = lista.get(0);
            }
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public List<Tbvehiculosdependencias> findAll(String placa) {
        List<Tbvehiculosdependencias> result = new ArrayList<>();
        try {
            String consulta = "SELECT t FROM Tbvehiculosdependencias t WHERE t.tbvehiculosdependenciasPK.matricula = :matricula Order by t.tbvehiculosdependenciasPK.fechainicio DESC";
            Query con = em.createQuery(consulta);
            con.setParameter("matricula", placa);
            result = con.getResultList();
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public Tbvehiculosdependencias find(String placa, Integer entidad) {
        Tbvehiculosdependencias result = new Tbvehiculosdependencias();
        List<Tbvehiculosdependencias> lista = new ArrayList<>();
        try {
            String consulta = "SELECT t FROM Tbvehiculosdependencias t WHERE t.tbvehiculosdependenciasPK.matricula = :matricula AND t.tbvehiculosdependenciasPK.iddependencia = :entidad  AND t.fechafin is null";
            Query con = em.createQuery(consulta);
            con.setParameter("matricula", placa);
            con.setParameter("entidad", entidad);
            lista = con.getResultList();
            if (lista.size() > 0 && lista.size() < 2) {
                result = lista.get(0);
            }
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public Tbvehiculosdependencias modificar(String placa, String entidad, Date fecha, Tbvehiculosdependencias tbvehiculosdependencias) {
        Tbvehiculosdependencias result = new Tbvehiculosdependencias();
        String consulta;
        try {
            consulta = "UPDATE Tbvehiculosdependencias t"
                    + " SET t.fechafin = :fechaf"
                    + " WHERE t.tbvehiculosdependenciasPK.matricula = :matricula"
                    + " AND t.tbvehiculosdependenciasPK.iddependencia = :entidad"
                    + " AND t.tbvehiculosdependenciasPK.fechainicio = :fechainicio";
            Query con = em.createQuery(consulta);
            con.setParameter("matricula", placa);
            con.setParameter("entidad", Integer.parseInt(entidad));
            con.setParameter("fechainicio", fecha, TemporalType.DATE);
            con.setParameter("fechaf", tbvehiculosdependencias.getFechafin());
            result = (con.executeUpdate() > 0) ? tbvehiculosdependencias : null;
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public Tbvehiculosdependencias find(Integer entidad) {
        Tbvehiculosdependencias result = new Tbvehiculosdependencias();
        List<Tbvehiculosdependencias> lista = new ArrayList<>();
        try {
            String consulta = "SELECT t FROM Tbvehiculosdependencias t WHERE t.tbvehiculosdependenciasPK.iddependencia = :entidad  AND t.fechafin is null Order by t.tbvehiculosdependenciasPK.fechainicio DESC";
            Query con = em.createQuery(consulta);
            con.setParameter("entidad", entidad);
            lista = con.getResultList();
            if (lista.size() > 0 && lista.size() < 2) {
                result = lista.get(0);
            }
        } catch (Exception e) {
        }
        return result;
    }

}
