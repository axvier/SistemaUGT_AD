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
import ugt.entidades.Tbseccionsolicitantes;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbseccionsolicitantesFacade extends AbstractFacade<Tbseccionsolicitantes> implements TbseccionsolicitantesFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbseccionsolicitantesFacade() {
        super(Tbseccionsolicitantes.class);
    }

    @Override
    public List<Tbseccionsolicitantes> buscarxcedula(String cedula) {
        List<Tbseccionsolicitantes> result = new ArrayList<>();
        String consulta;
        try {
            consulta = "SELECT c FROM Tbseccionsolicitantes c WHERE c.cedulau.cedula = :ced";
            Query query = em.createQuery(consulta);
            query.setParameter("ced", cedula);
            result = query.getResultList();
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public Tbseccionsolicitantes buscarxidsolicitud(String idsolicitud) {
        Tbseccionsolicitantes result = new Tbseccionsolicitantes();
        List<Tbseccionsolicitantes> lista = new ArrayList<>();
        String consulta;
        try {
            consulta = "SELECT t FROM Tbseccionsolicitantes t WHERE t.solicitud.numero = :id";
            Query con = em.createQuery(consulta);
            con.setParameter("id", Integer.parseInt(idsolicitud));
            lista = con.getResultList();
            if(lista.size() > 0 && lista.size() < 2){
                result = lista.get(0);
            }
        } catch (Exception e) {
        }
        return result;
    }
    
}
