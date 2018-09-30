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
import ugt.entidades.Tbvehiculosconductores;

/**
 *
 * @author Usuario
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
    public Tbvehiculosconductores buscarxcedula(String cedula) {
        Tbvehiculosconductores result = new Tbvehiculosconductores();
        List<Tbvehiculosconductores> listavehiculo = null;
        String consulta;
        try {
            consulta = "SELECT t FROM Tbvehiculosconductores t WHERE t.tbvehiculosconductoresPK.cedula = :cedula and t.fechafin is null";
            Query con = em.createQuery(consulta);
            con.setParameter("cedula", cedula);
            listavehiculo = con.getResultList();
            if(listavehiculo.size() > 0  && listavehiculo.size() < 2){
                result = listavehiculo.get(0);
            }
        } catch (Exception e) {
        }
        return result;
    }
    
}
