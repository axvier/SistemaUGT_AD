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
import ugt.entidades.Tbrolesopciones;

/**
 *
 * @author Xavy PC
 */
@Stateless
@Path("tbrolesopciones")
public class TbrolesopcionesFacadeREST extends AbstractFacade<Tbrolesopciones> {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    public TbrolesopcionesFacadeREST() {
        super(Tbrolesopciones.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Transactional
    public Tbrolesopciones insertar(Tbrolesopciones entity) {
        Tbrolesopciones obj= new Tbrolesopciones();
        super.create(entity);
        em.flush();
        obj= entity;
        return obj;
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Transactional
    public Tbrolesopciones modificar(@PathParam("id") Integer id, Tbrolesopciones entity) {
        Tbrolesopciones obj = new Tbrolesopciones();
        super.edit(entity);
        em.flush();
        obj = entity;
        return obj;
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Tbrolesopciones find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tbrolesopciones> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tbrolesopciones> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
