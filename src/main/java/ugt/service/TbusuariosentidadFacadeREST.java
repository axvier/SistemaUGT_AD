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
import javax.ws.rs.core.PathSegment;
import ugt.entidades.Tbusuariosentidad;
import ugt.entidades.TbusuariosentidadPK;

/**
 *
 * @author Usuario
 */
@Stateless
@Path("tbusuariosentidad")
public class TbusuariosentidadFacadeREST extends AbstractFacade<Tbusuariosentidad> {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    private TbusuariosentidadPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;identidad=identidadValue;cedulau=cedulauValue;idrol=idrolValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ugt.entidades.TbusuariosentidadPK key = new ugt.entidades.TbusuariosentidadPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> identidad = map.get("identidad");
        if (identidad != null && !identidad.isEmpty()) {
            key.setIdentidad(new java.lang.Integer(identidad.get(0)));
        }
        java.util.List<String> cedulau = map.get("cedulau");
        if (cedulau != null && !cedulau.isEmpty()) {
            key.setCedulau(cedulau.get(0));
        }
        java.util.List<String> idrol = map.get("idrol");
        if (idrol != null && !idrol.isEmpty()) {
            key.setIdrol(new java.lang.Integer(idrol.get(0)));
        }
        return key;
    }

    public TbusuariosentidadFacadeREST() {
        super(Tbusuariosentidad.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Transactional
    public Tbusuariosentidad insertar(Tbusuariosentidad entity) {
        Tbusuariosentidad obj = new Tbusuariosentidad();
        super.create(entity);
        em.flush();
        obj= entity;
        return entity;
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Transactional
    public Tbusuariosentidad edit(@PathParam("id") PathSegment id, Tbusuariosentidad entity) {
        Tbusuariosentidad obj = new Tbusuariosentidad();
        super.edit(entity);
        em.flush();
        obj= entity;
        return entity;
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        ugt.entidades.TbusuariosentidadPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Tbusuariosentidad find(@PathParam("id") PathSegment id) {
        ugt.entidades.TbusuariosentidadPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tbusuariosentidad> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tbusuariosentidad> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
