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
import ugt.entidades.Tbviajepasajero;
import ugt.entidades.TbviajepasajeroPK;

/**
 *
 * @author Xavy PC
 */
@Stateless
@Path("tbviajepasajero")
public class TbviajepasajeroFacadeREST extends AbstractFacade<Tbviajepasajero> {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    private TbviajepasajeroPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idviaje=idviajeValue;cedulap=cedulapValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ugt.entidades.TbviajepasajeroPK key = new ugt.entidades.TbviajepasajeroPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idviaje = map.get("idviaje");
        if (idviaje != null && !idviaje.isEmpty()) {
            key.setIdviaje(new java.lang.Integer(idviaje.get(0)));
        }
        java.util.List<String> cedulap = map.get("cedulap");
        if (cedulap != null && !cedulap.isEmpty()) {
            key.setCedulap(java.lang.String.valueOf(cedulap.get(0)));
        }
        return key;
    }

    public TbviajepasajeroFacadeREST() {
        super(Tbviajepasajero.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Transactional
    public Tbviajepasajero insertar(Tbviajepasajero entity) {
        Tbviajepasajero obj = new Tbviajepasajero();
        super.create(entity);
        em.flush();
        obj = entity;
        return obj;
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Transactional
    public Tbviajepasajero modificar(@PathParam("id") PathSegment id, Tbviajepasajero entity) {
        Tbviajepasajero obj = new Tbviajepasajero();
        super.edit(entity);
        em.flush();
        obj = entity;
        return obj;
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        ugt.entidades.TbviajepasajeroPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Tbviajepasajero find(@PathParam("id") PathSegment id) {
        ugt.entidades.TbviajepasajeroPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tbviajepasajero> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tbviajepasajero> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
