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
import ugt.entidades.Tbrevisionesmecanicas;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbrevisionesmecanicasFacade extends AbstractFacade<Tbrevisionesmecanicas> implements TbrevisionesmecanicasFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbrevisionesmecanicasFacade() {
        super(Tbrevisionesmecanicas.class);
    }

    @Override
    public List<Tbrevisionesmecanicas> filtrarXsolicitud(String placa) {
        List<Tbrevisionesmecanicas> lista = new ArrayList<>();
        String consulta;
        try {
            consulta = "SELECT t FROM Tbrevisionesmecanicas t WHERE t.matricula.placa = :idplaca ORDER BY t.fecha DESC";
            Query con = em.createQuery(consulta);
            con.setParameter("idplaca", placa);
            lista = con.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }
    
}
