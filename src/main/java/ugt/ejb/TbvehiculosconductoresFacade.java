/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ugt.entidades.Tbvehiculosconductores;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbvehiculosconductoresFacade extends AbstractFacade<Tbvehiculosconductores> implements TbvehiculosconductoresFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbvehiculosconductoresFacade() {
        super(Tbvehiculosconductores.class);
    }

    @Override
    public List<Tbvehiculosconductores> buscarxcedula(String cedula) {
        Tbvehiculosconductores result = new Tbvehiculosconductores();
        List<Tbvehiculosconductores> listavehiculo = null;
        String consulta;
        try {
            consulta = "SELECT t FROM Tbvehiculosconductores t WHERE t.tbvehiculosconductoresPK.cedula = :cedula and t.fechafin is null";
            Query con = em.createQuery(consulta);
            con.setParameter("cedula", cedula);
            listavehiculo = con.getResultList();
            if (listavehiculo.size() > 0 && listavehiculo.size() < 2) {
                result = listavehiculo.get(0);
            }
        } catch (Exception e) {
        }
        return listavehiculo;
    }

    @Override
    public Tbvehiculosconductores buscarxplaca(String placav) {
        Tbvehiculosconductores result = new Tbvehiculosconductores();
        List<Tbvehiculosconductores> listavehiculo = null;
        String consulta;
        try {
            consulta = "SELECT t FROM Tbvehiculosconductores t WHERE t.tbvehiculosconductoresPK.matricula = :placa and t.fechafin is null";
            Query con = em.createQuery(consulta);
            con.setParameter("placa", placav);
            listavehiculo = con.getResultList();
            if (listavehiculo.size() > 0 && listavehiculo.size() < 2) {
                result = listavehiculo.get(0);
            }
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public Tbvehiculosconductores modificar(String cedula, String placa, String fecha, Tbvehiculosconductores obj) {
        Tbvehiculosconductores result = new Tbvehiculosconductores();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String consulta;
        try {
            consulta = "UPDATE Tbvehiculosconductores t SET t.fechafin = :fechaf WHERE t.tbvehiculosconductoresPK.matricula = :matricula AND t.tbvehiculosconductoresPK.cedula = :cedula AND t.tbvehiculosconductoresPK.fechainicio = :fechainicio";
            Query con = em.createQuery(consulta);
            con.setParameter("matricula", placa);
            con.setParameter("cedula", cedula);
            con.setParameter("fechaf", obj.getFechafin());
            con.setParameter("fechainicio", obj.getTbvehiculosconductoresPK().getFechainicio());
            result = (con.executeUpdate() > 0) ? obj : null;
        } catch (Exception e) {
        }
        return result;
    }

}
