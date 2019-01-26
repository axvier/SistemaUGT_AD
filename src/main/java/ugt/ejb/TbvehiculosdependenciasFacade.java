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
            if(lista.size()>0 && lista.size()<2){
                result = lista.get(0);
            }
        } catch (Exception e) {
        }
        return result;
    }
    
}
