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
import ugt.entidades.Tbviajepasajero;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbviajepasajeroFacade extends AbstractFacade<Tbviajepasajero> implements TbviajepasajeroFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbviajepasajeroFacade() {
        super(Tbviajepasajero.class);
    }

    @Override
    public List<Tbviajepasajero> buscarXIDviaje(Integer id) {
        List<Tbviajepasajero> lista = new ArrayList<>();
        String consulta;
        try {
            consulta = "SELECT t FROM Tbviajepasajero t WHERE t.tbviajepasajeroPK.idviaje = :idviaje";
            Query con = em.createQuery(consulta);
            con.setParameter("idviaje", id);
            lista = con.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }
    
}
