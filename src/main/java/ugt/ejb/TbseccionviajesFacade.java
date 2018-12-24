/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ugt.entidades.Tbseccionviajes;

/**
 *
 * @author Xavy PC
 */
@Stateless
public class TbseccionviajesFacade extends AbstractFacade<Tbseccionviajes> implements TbseccionviajesFacadeLocal {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbseccionviajesFacade() {
        super(Tbseccionviajes.class);
    }

    @Override
    public Tbseccionviajes buscaridS(String idSolcitud) {
        Tbseccionviajes result = new Tbseccionviajes();
        try {
            String cosulta = "SELECT t FROM Tbseccionviajes t WHERE t.solicitud.numero = :idsol";
            Query query = em. createQuery(cosulta);
            query.setParameter("idsol", Integer.parseInt(idSolcitud));
            result = (Tbseccionviajes) query.getParameter(1);
        } catch (Exception e) {
        }
        return result;
    }
    
}
