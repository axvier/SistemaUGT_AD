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
import ugt.entidades.Tbdisponibilidadvc;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbdisponibilidadvcFacade extends AbstractFacade<Tbdisponibilidadvc> implements TbdisponibilidadvcFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbdisponibilidadvcFacade() {
        super(Tbdisponibilidadvc.class);
    }

    @Override
    public Tbdisponibilidadvc buscarXSol(String idsol) {
        Tbdisponibilidadvc result = new Tbdisponibilidadvc();
        List<Tbdisponibilidadvc> listAux = new ArrayList<>();
        String consulta;
        try {
            consulta = "SELECT t FROM Tbdisponibilidadvc t WHERE t.solicitud.numero = :id";
            Query con = em.createQuery(consulta);
            con.setParameter("id", Integer.parseInt(idsol));
            listAux = con.getResultList();
            if(listAux.size() > 0 && listAux.size()<2){
                result = listAux.get(0);
            }
        } catch (NumberFormatException e) {
        }
        return result;
    }

    @Override
    public List<Tbdisponibilidadvc> buscarXPlaca(String placa) {
        List<Tbdisponibilidadvc> result = new ArrayList<>();
        String consulta;
        try {
            consulta = "SELECT t FROM Tbdisponibilidadvc t WHERE t.matricula.placa = :placa";
            Query con = em.createQuery(consulta);
            con.setParameter("placa", placa);
            result = con.getResultList();
        } catch (NumberFormatException e) {
        }
        return result;
    }

}
