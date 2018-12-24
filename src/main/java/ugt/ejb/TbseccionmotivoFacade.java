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
import ugt.entidades.Tbseccionmotivo;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbseccionmotivoFacade extends AbstractFacade<Tbseccionmotivo> implements TbseccionmotivoFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbseccionmotivoFacade() {
        super(Tbseccionmotivo.class);
    }

    @Override
    public Tbseccionmotivo buscarXIDsolicitud(int id) {
        Tbseccionmotivo result = new Tbseccionmotivo();
        List<Tbseccionmotivo> lista = new ArrayList<>();
        String consulta;
        try {
            consulta = "SELECT t FROM Tbseccionmotivo t WHERE t.solicitud.numero = :numero";
            Query con = em.createQuery(consulta);
            con.setParameter("numero", id);
            lista = con.getResultList();
            if (lista.size() > 0 && lista.size() < 2) {
                result = lista.get(0);
            }
        } catch (Exception e) {
            System.out.println("ugt.ejb.TbseccionmotivoFacade.buscarXIDsolicitud()\n" + e.getMessage() + "\n" + e);
        }
        return result;
    }

}
