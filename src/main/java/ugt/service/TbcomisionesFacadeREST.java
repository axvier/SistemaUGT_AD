/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ugt.entidades.Tbcomisiones;

/**
 *
 * @author Xavy PC
 */
@Stateless
@Path("tbcomisiones")
public class TbcomisionesFacadeREST extends AbstractFacade<Tbcomisiones> {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    public TbcomisionesFacadeREST() {
        super(Tbcomisiones.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @Transactional
    public Tbcomisiones ingresar(Tbcomisiones entity) {
        Tbcomisiones obj = new Tbcomisiones();
        super.create(entity);
        em.flush();
        obj = entity;
        return obj;
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Tbcomisiones modificar(@PathParam("id") String id, Tbcomisiones entity) {
        Tbcomisiones obj = new Tbcomisiones();
        super.edit(entity);
        em.flush();
        obj = entity;
        return obj;
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Tbcomisiones find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tbcomisiones> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tbcomisiones> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
