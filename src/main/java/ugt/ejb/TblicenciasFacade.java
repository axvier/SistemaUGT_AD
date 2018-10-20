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
import ugt.entidades.Tblicencias;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TblicenciasFacade extends AbstractFacade<Tblicencias> implements TblicenciasFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblicenciasFacade() {
        super(Tblicencias.class);
    }

    @Override
    public List<Tblicencias> buascarLicencia(String cedula) {
        List<Tblicencias> result = null;
        String consulta;
        try {
            consulta = "SELECT c FROM Tblicencias c WHERE c.cedulac.cedula = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, cedula);
            result = query.getResultList();
        } catch (Exception e) {
}
        return result;
    }

}
