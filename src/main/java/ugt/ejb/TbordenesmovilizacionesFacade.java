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
import ugt.entidades.Tbordenesmovilizaciones;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbordenesmovilizacionesFacade extends AbstractFacade<Tbordenesmovilizaciones> implements TbordenesmovilizacionesFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbordenesmovilizacionesFacade() {
        super(Tbordenesmovilizaciones.class);
    }

    @Override
    public Tbordenesmovilizaciones filtrarOrdenXIdsol(Integer idsolicitud) {
        Tbordenesmovilizaciones result = null;
        List<Tbordenesmovilizaciones> listAux = new ArrayList<>();
        String consulta;
        try {
            consulta = "SELECT t FROM Tbordenesmovilizaciones t WHERE t.solicitud.numero = :id";
            Query con = em.createQuery(consulta);
            con.setParameter("id", idsolicitud);
            listAux = con.getResultList();
            if (listAux.size() > 0 && listAux.size() < 2) {
                result = listAux.get(0);
            }
        } catch (NumberFormatException e) {
        }
        return result;
    }

    @Override
    public List<Tbordenesmovilizaciones> findAllOderby(String campo, String orden) {
        List<Tbordenesmovilizaciones> result = new ArrayList<>();
        String consulta;
        try {
            consulta = "SELECT t FROM Tbordenesmovilizaciones t Order by t." + campo + " " + orden;
            Query con = em.createQuery(consulta);
            result = con.getResultList();
        } catch (NumberFormatException e) {
        }
        return result;
    }

}
